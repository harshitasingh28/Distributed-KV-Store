package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class KeyValueClient {

    public static void main(String[] args) {

        try{

            Socket socket = new Socket("localhost",5000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            while(true){

                System.out.print(">> ");

                String command = scanner.nextLine();

                output.println(command);

                String response = input.readLine();

                System.out.println("Server: " + response);

            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}