package de.thws.Lektion18.vierte;

import java.io.*;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

public class Client {
    public static void main(String[] args) throws IOException {
        byte[] bytesToTransfer = "Hallo Welt\n".getBytes();

        // Verbindung zum Server aufbauen
        Socket connectionToHost = new Socket("localhost", 5555);

        // Ausgangs-Stream vom Socket holen
        OutputStream os = connectionToHost.getOutputStream();

        // GZIPOutputStream dekoriert den normalen OutputStream
        try (GZIPOutputStream gzipOut = new GZIPOutputStream(os)) {
            gzipOut.write(bytesToTransfer);   // Daten komprimiert schreiben
        }

        connectionToHost.close(); // Verbindung schließen
    }
}

