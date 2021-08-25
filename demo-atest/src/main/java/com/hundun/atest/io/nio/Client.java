package com.hundun.atest.io.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
    public static void main(String[] args){

        Channel client = new NioSocketChannel();
        // 创建默认，分配了一个 pipeline
        ChannelPipeline pipeline = client.pipeline();
        ChannelHandler handler = new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                System.out.println("test channel init!");
            }
        };
        client.pipeline().addFirst(handler);
    }
}
