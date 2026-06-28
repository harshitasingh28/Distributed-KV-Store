package server;

import java.net.ServerSocket;
import java.net.Socket;

public class KeyValueServer {

    public static void main(String[] args) {

        int port = 5000;

        try{

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started on port " + port);

            while(true){

                Socket socket = serverSocket.accept();

                System.out.println("Client connected");

                Thread thread = new Thread(new ClientHandler(socket));

                thread.start();

            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}