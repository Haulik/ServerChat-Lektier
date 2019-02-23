package com.company.Person2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer2 implements Runnable {

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            Socket socket = serverSocket.accept(); // blokerer
            System.out.println("Forbundet til Klient 3");


            Thread thread = new Thread(new ChatServer2_1());
            thread.start();


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