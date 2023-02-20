package netty.sample.action.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import netty.sample.action.handler.EchoServerHandler;

import java.net.InetSocketAddress;

public class NettyEchoServer {

    public static void main(String[] args) throws InterruptedException {
        new NettyEchoServer(4566).start();
    }

    private final int port;

    public NettyEchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap strap = new ServerBootstrap();
            strap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = strap.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
