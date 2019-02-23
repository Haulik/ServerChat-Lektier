package com.company.Person1;

import com.company.Person3.ChatClient3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {


    @Override
    public void run() {


        try {
            Socket socket = new Socket("localhost", 3050);
            System.out.println("Er forbundet til server2");

            Socket socket2 = new Socket("localhost", 1018);
            System.out.println("Er forbundet til server3");

            // Send til server:
            Scanner scanner = new Scanner(System.in);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dOut2 = new DataOutputStream(socket2.getOutputStream());

            ChatClient.GetOutput(scanner, dOut, dOut2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void GetOutput(Scanner scanner, DataOutputStream dOut, DataOutputStream dOut2) throws IOException {
        while (true) {
            String Line = scanner.nextLine();
            dOut.writeBytes( Line + "\n");
            dOut2.writeBytes(Line + "\n");
            dOut.flush();
        }
    }
}
