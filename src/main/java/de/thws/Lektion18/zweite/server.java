package de.thws.Lektion18.zweite;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket( 1234);

        while(true){
            try{

                socket = serverSocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){
                    String msgFromClient = bufferedReader.readLine();

                    System.out.println("Client: " + msgFromClient );

                    bufferedWriter.write("MSG RECEIVED.");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if(msgFromClient.equalsIgnoreCase("BYE")){
                        break;
                    }

                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedWriter.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
