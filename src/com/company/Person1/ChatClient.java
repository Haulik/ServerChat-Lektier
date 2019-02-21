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
            System.out.println("Er forbundet til server");

//            Thread thread = new Thread(new ChatServer0_1());
//            thread.start();

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
