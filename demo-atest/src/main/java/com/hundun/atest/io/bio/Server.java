package com.hundun.atest.io.bio;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(6666));
        while (true) {
            Socket socket = server.accept();
            new IoThread(socket).start();
        }
    }

    static class IoThread extends Thread {

        Socket socket;

        public IoThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            byte[] bytes = new byte[1024];
            int count = 0;
            int bt = 0;

            StringBuilder buffer = new StringBuilder();
            try {
                if(socket.getInputStream().read(bytes) != -1 ) {
                    count++;
                    System.out.println("[Count] :" + count + " ,[InputStream] : " + new String(bytes));
                }
                OutputStreamWriter potw = new OutputStreamWriter(socket.getOutputStream());
                potw.write("Hello Client. I'm Server");
                potw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
