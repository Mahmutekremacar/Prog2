package de.thws.Lektion18.zweiteFinal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class server {

    static Path baseDir = Paths.get("Prog2","src","main","java","de","thws","Lektion18","zweiteFinal","WOERTER.txt.txt");

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

                char[] wort =zufaelligAuswahl.getRandomWordAsCharArray(String.valueOf(baseDir));
                System.out.println(wort);
//                woerterrreader = Files.newBufferedReader(baseDir.resolve("WOERTER.txt.txt"));

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
