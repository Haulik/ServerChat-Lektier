package com.company.Person1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {


    @Override
    public void run() {


        try {
            Socket socket = new Socket("localhost", 5050);
            System.out.println("Er forbundet til server2");

            Socket socket2 = new Socket("localhost", 1018);
            System.out.println("Er forbundet til server3");

            Thread thread = new Thread(new ChatServer1_1());
            thread.start();
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
