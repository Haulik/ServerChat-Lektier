package com.company.Person2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.company.Person1.ChatClient;



public class ChatClient2 {

    public static void main(String[] args) {
        new ChatClient2().runClient();

    }

    public void runClient() {

        try {
            Socket socket = new Socket("localhost", 1337);
            System.out.println("Er forbundet til server1");

            Thread thread = new Thread(new ChatServer2());
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Socket socket2 = new Socket("localhost", 1028);
            System.out.println("Er forbundet til server3");

            //lyt til server

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dOut2 = new DataOutputStream(socket2.getOutputStream());

            ChatClient.GetOutput(scanner, dOut, dOut2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
