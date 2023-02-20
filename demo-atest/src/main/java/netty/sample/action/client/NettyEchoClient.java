package netty.sample.action.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.sample.action.handler.EchoClientHandler;

import java.net.InetSocketAddress;

public class NettyEchoClient {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 4566;
        new NettyEchoClient(host, port).start();
    }

    private final String host;
    private final int port;

    public NettyEchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        // 处理监听的 sever channel
        EventLoopGroup group = new NioEventLoopGroup();
        // 处理 accept 后与客户端相连的 Channel
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
