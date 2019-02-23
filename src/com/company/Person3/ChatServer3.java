package com.company.Person3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ChatServer3 {



    public static void main(String[] args) {
        new ChatServer3().runServer();

    }

    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(2080);
            Socket socket = serverSocket.accept(); // blokerer
            System.out.println("Forbundet til Klient ");

            Thread thread = new Thread(new ChatServer4());
            thread.start();


            //send til klient
            //lyt til server

            //lyt til klient;
            try (Scanner scanner = new Scanner(socket.getInputStream())){
                while (true){
                    System.out.println(scanner.nextLine()); // blokerer

                }
            } catch (Exception e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
