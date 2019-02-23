package com.company.Person2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient2 {


    public static void main(String[] args) {
        new ChatClient2().runClient();
    }

    public void runClient() {

        try {
            Socket socket = new Socket("localhost", 1337);
            System.out.println("Er forbundet til server1");

            Socket socket2 = new Socket("localhost", 2080);
            System.out.println("Er forbundet til server3");

            //lyt til server
            Thread thread = new Thread(new ChatServer2());
            thread.start();

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dOut2 = new DataOutputStream(socket2.getOutputStream());

            while (true) {
                String Line = scanner.nextLine();
                dOut.writeBytes( Line + "\n");
                dOut2.writeBytes(Line + "\n");
                dOut.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
