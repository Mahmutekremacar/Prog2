package de.thws.Lektion18.zweiteFinal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 1234;

        try (
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to Hangman Server ✅");

            String serverMessage;

            // Print initial messages from server (welcome, instructions)
            while ((serverMessage = serverReader.readLine()) != null) {
                System.out.println("Server: " + serverMessage);
                if (serverMessage.contains("Guess a letter:")) break; // wait for game start
            }

            // Game loop
            while (true) {
                System.out.print("Your guess (type a letter or BYE): ");
                String userInput = scanner.nextLine().trim();

                // Send input to server
                serverWriter.write(userInput);
                serverWriter.newLine();
                serverWriter.flush();

                // Read and display server responses
                while ((serverMessage = serverReader.readLine()) != null) {
                    System.out.println("Server: " + serverMessage);

                    // Game ends if server says game over or win
                    if (serverMessage.contains("GAME END") ||
                            serverMessage.contains("won") ||
                            serverMessage.contains("Game over")) {
                        return; // exit program
                    }

                    // If server now expects another letter, we break to prompt input again
                    if (serverMessage.startsWith("Word:") ||
                            serverMessage.startsWith("❌") ||
                            serverMessage.startsWith("🔁") ||
                            serverMessage.startsWith("⚠️")) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Connection error: " + e.getMessage());
        }
    }
}
