package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Server {

    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        // 创建NIO ServerSocketChannel,与BIO的serverSocket类似
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 设置ServerSocketChannel为非阻塞
        serverChannel.configureBlocking(false);
        // 绑定端口
        serverChannel.socket().bind(new InetSocketAddress(6666));
        // 轮询器
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
        while (true) {
            selector.select();
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel acceptChannel = (ServerSocketChannel) key.channel();
                    SocketChannel client = acceptChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
                    System.out.println("Accepted connection from " + client);
                }
                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    while (buffer.hasRemaining()) {
                        if(client.write(buffer) == 0) {
                            break;
                        }
                    }
                }
                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer read = ByteBuffer.allocate(1024 * 16);
                    while (client.read(read) != 0) {
                        System.out.println("Accepted from Client-" + client + ",message:" + new String(read.array()));
                    }
                    client.close();
                }

            }
        }


    }

}
