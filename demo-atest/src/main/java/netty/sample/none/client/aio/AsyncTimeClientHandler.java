package netty.sample.none.client.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable {

    private AsynchronousSocketChannel client;
    private String host;
    private int port;
    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        client.connect(new InetSocketAddress(host, port), this, this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        String req = "QUERY TIME ORDER";
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.getBytes().length);
        writeBuffer.put(req.getBytes());
        writeBuffer.flip();
        client.write(writeBuffer, writeBuffer,
                new CompletionHandler<Integer, ByteBuffer>( ) {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if(writeBuffer.hasRemaining()) {
                            client.write(writeBuffer, writeBuffer, this);
                        } else {
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            client.read(readBuffer, readBuffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result, ByteBuffer attachment) {
                                            attachment.flip();
                                            byte[] bytes = new byte[attachment.remaining()];
                                            attachment.get(bytes);
                                            String body;
                                            try {
                                                body = new String(bytes, StandardCharsets.UTF_8);
                                                System.out.println("Now is :" + body);
                                                latch.countDown();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {
                                            try {
                                                client.close();
                                                latch.countDown();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            client.close();
                            latch.countDown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
