package netty.sample.none.client;

import netty.sample.none.client.aio.AsyncTimeClientHandler;
import netty.sample.none.client.netty.NettyTimeClient;
import netty.sample.none.client.nio.TimeClientHandle;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        String host = "127.0.0.1";
//        startTimeClient(port);
//        startAsyncTimeClient(port, host);
        new NettyTimeClient().bind(host, port);
    }

    private static void startAsyncTimeClient(int port, String host) {
        new Thread(new AsyncTimeClientHandler(host, port), "AsyncTimeClient")
            .start();
    }

    private static void startTimeClient(int port) {
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient")
                .start();
    }
}
