package com.company.Person2;

import com.company.Person2.ChatClient2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer2_1 implements Runnable {

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(3050);
            Socket socket = serverSocket.accept(); // blokerer
            System.out.println("Forbundet til Klient 1");


            //lyt til klient;
            try (Scanner scanner = new Scanner(socket.getInputStream())) {
                while (true) {
                    System.out.println(scanner.nextLine()); // blokerer


                }
            } catch (Exception e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
