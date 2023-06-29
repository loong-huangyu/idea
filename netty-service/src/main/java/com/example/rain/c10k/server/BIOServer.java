package com.example.rain.c10k.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author rain
 * @description:
 * @date 2023/6/21 2:40 下午
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9998, 20);
        System.out.println("server begin");
        while (true) {
            //阻塞1
            Socket client = server.accept();
            System.out.println("accept client" + client.getPort());
            new Thread(() -> {
                InputStream in;
                try {
                    in = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    while (true) {
                        //阻塞2
                        String data = reader.readLine();
                        if (null != data) {
                            System.out.println(data);
                        } else {
                            client.close();
                            break;
                        }
                    }
                    System.out.println("client break");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
