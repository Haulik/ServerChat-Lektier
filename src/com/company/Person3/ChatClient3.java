package com.company.Person3;


import com.company.Person1.ChatClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient3 {


    public static void main(String[] args) {
        new ChatClient3().runClient();
    }

    public void runClient() {

        try {
            Socket socket = new Socket("localhost", 1040);
            System.out.println("Er forbundet til server1");


            Socket socket2 = new Socket("localhost", 5050);
            System.out.println("Er forbundet til server2");

            Thread thread = new Thread(new ChatServer3());
            thread.start();

            //lyt til server

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dOut2 = new DataOutputStream(socket2.getOutputStream());

            ChatClient.GetOutput(scanner, dOut, dOut2);
            return;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



