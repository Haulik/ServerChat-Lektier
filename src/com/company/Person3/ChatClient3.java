package com.company.Person3;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient3 implements Runnable {


    @Override
    public void run() {


        try {
            Socket socket = new Socket("localhost", 1040);
            System.out.println("Er forbundet til server 1_1");

            Socket socket2 = new Socket("localhost", 3050);
            System.out.println("Er forbundet til server 2_1");

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dOut2 = new DataOutputStream(socket2.getOutputStream());

            while (true) {
                String line = scanner.nextLine();
                dOut.writeBytes(line + "\n");
                dOut2.writeBytes(line + "\n");
                dOut.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



