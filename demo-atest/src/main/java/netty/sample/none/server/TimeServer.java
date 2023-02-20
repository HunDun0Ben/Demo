package netty.sample.none.server;

import netty.sample.none.server.aio.AsyncTimeServerHandler;
import netty.sample.none.server.netty.NettyTimeServer;
import netty.sample.none.server.nio.MultiplexerTimeServer;

public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
//        startMultiplexerTimeServer(port);
//        startAsyncTimeServer(port);
        startNettyTimeServer(port);
    }

    private static void startNettyTimeServer(int port) {
        new NettyTimeServer().bind(port);
    }

    private static void startAsyncTimeServer(int port) {
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-TimeServer-001").start();
    }

    private static void startMultiplexerTimeServer(int port) {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-TimeServer-001").start();
    }


}
