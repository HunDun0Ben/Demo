package com.hundun.atest.io.nio;

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
        Selector selector = null;
        try {
            // 创建NIO ServerSocketChannel,与BIO的serverSocket类似
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            // 设置ServerSocketChannel为非阻塞
            serverChannel.configureBlocking(false);
            // 绑定端口
            serverChannel.socket().bind(new InetSocketAddress(6666));
            // 轮询器
            selector = Selector.open();
            // ServerChannel 向 selector 注册 accept 事件
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
        while (true) {
            try {
                assert selector != null;
                selector.select();
                // 获取符合要求的 Key， 这里是， server 的 accept event
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        // 从 key 中获取 serverChannel 的 reference
                        ServerSocketChannel acceptChannel = (ServerSocketChannel) key.channel();
                        // 获取客户端 client
                        SocketChannel client = acceptChannel.accept();
                        client.configureBlocking(false);
                        // 注册 clientChannel 的 read&write event
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
                        System.out.println("Accepted connection from " + client);
                    }
                    // 只有 ClientChannel 会是可写的
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        System.out.println("I think Only Clinet Channel is writable. " + client);
                        // because server channel not register op_write event.
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        key.cancel();
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
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
