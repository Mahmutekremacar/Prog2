package de.thws.Lektion18.vierte;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server läuft auf Port 5555...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client verbunden!");

            // Eingangs-Stream vom Client holen
            InputStream is = clientSocket.getInputStream();

            // GZIPInputStream dekoriert den InputStream
            try (GZIPInputStream gzipIn = new GZIPInputStream(is);
                 InputStreamReader isr = new InputStreamReader(gzipIn);
                 BufferedReader br = new BufferedReader(isr)) {

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Empfangen: " + line);
                }
            }

            clientSocket.close();
        }
    }
}

