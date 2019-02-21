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
            System.out.println("Er forbundet til server");

            //lyt til server
            Thread thread = new Thread(new ChatServer2());
            thread.start();

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            while (true) {
                dOut.writeBytes(scanner.nextLine() + "\n");
                dOut.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
