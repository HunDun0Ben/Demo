package com.hundun.atest.io.bio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",6666));
        socket.getOutputStream().write("afkldlsjfjfdlkajflkdjsadfsaf".getBytes());
        InputStreamReader reader = new InputStreamReader(socket.getInputStream());
        while (true) {
            if(reader.ready()) {
                char[] buf = new char[1024];
                reader.read(buf);
                System.out.println(new String(buf));
            }

        }
    }
}
