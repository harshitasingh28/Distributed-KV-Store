package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

        try{

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String command;

            while((command = input.readLine()) != null){

                String[] parts = command.split(" ");

                String response = "";

                switch(parts[0].toUpperCase()){

                    case "SET":
                        response = KeyValueStore.set(parts[1], parts[2]);
                        break;

                    case "GET":
                        response = KeyValueStore.get(parts[1]);
                        break;

                    case "DELETE":
                        response = KeyValueStore.delete(parts[1]);
                        break;

                    default:
                        response = "INVALID COMMAND";
                }

                PersistenceManager.save(KeyValueStore.getStore());

                output.println(response);

            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
