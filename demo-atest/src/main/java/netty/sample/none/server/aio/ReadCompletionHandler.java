package netty.sample.none.server.aio;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel result) {
        if (this.channel == null) {
            this.channel = result;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, StandardCharsets.UTF_8);
            System.out.println("ReadCompletionHandler completed result: " + result);
            System.out.println("The time server receive order : " + req);
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req)
                    ? new Date(System.currentTimeMillis()).toString()
                    : "BAD ORDER";
            doWrite(currentTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currentTime) {
        if (StringUtils.isNotEmpty(currentTime)) {
            byte[] bytes = currentTime.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                    System.out.println("ReadCompletionHandler doWrite result: " + result);
                    if (buffer.hasRemaining()) {
                        channel.write(buffer, buffer, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
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
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
