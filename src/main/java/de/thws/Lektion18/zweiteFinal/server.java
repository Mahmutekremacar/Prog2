package de.thws.Lektion18.zweiteFinal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.util.*;

public class server {

    static Path baseDir = Paths.get("Prog2", "src", "main", "java", "de", "thws", "Lektion18", "zweiteFinal", "WOERTER.txt");

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is running and waiting for clients...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected.");

                    // Get random word
                    char[] wort = zufaelligAuswahl.getRandomWordAsCharArray(String.valueOf(baseDir));
                    String originalWord = new String(wort).toLowerCase();
                    Set<Character> guessedLetters = new HashSet<>();
                    int remainingTries = 6;

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    bufferedWriter.write(" Welcome to Hangman!");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Guess a letter:");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

//                    StringBuilder starter = null;
//                    for (int i =0; i < originalWord.length(); i++){
//                        starter.append("_ ");
//                    }
//
//                    bufferedWriter.write(starter.toString());
//                    bufferedWriter.newLine();


                    while (remainingTries > 0) {
                        String msgFromClient = bufferedReader.readLine();

                        if (msgFromClient == null || msgFromClient.equalsIgnoreCase("BYE")) {
                            break;
                        }

                        msgFromClient = msgFromClient.trim().toLowerCase();

                        char guessed = msgFromClient.charAt(0);

                        if (msgFromClient.length() != 1 || !Character.isLetter(guessed)) {
                            bufferedWriter.write("Please enter a single valid letter.");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            continue;
                        }



                        if (guessedLetters.contains(guessed)) {
                            bufferedWriter.write("Already guessed '" + guessed + "'. Try another.");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            continue;
                        }

                        guessedLetters.add(guessed);

                        if (!originalWord.contains(String.valueOf(guessed))) {
                            remainingTries--;
                            bufferedWriter.write(" Wrong! Remaining tries: " + remainingTries);
                            bufferedWriter.newLine();
                        }

                        // Build current word display
                        StringBuilder displayWord = new StringBuilder();
                        boolean won = true;

                        for (char c : originalWord.toCharArray()) {
                            if (guessedLetters.contains(c)) {
                                displayWord.append(c);
                            } else {
                                displayWord.append('_');
                                won = false;
                            }
                            displayWord.append(' ');
                        }

                        bufferedWriter.write("Word: " + displayWord.toString().trim());
                        bufferedWriter.newLine();

                        if (won) {
                            bufferedWriter.write( "You won! The word was: " + originalWord);
                            bufferedWriter.newLine();
                            break;
                        }

                        if (remainingTries == 0) {
                            bufferedWriter.write(" Game over. The word was: " + originalWord);
                            bufferedWriter.newLine();
                        }

                        bufferedWriter.flush();
                    }

                    bufferedWriter.write("GAME END");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    System.out.println("Game finished for a client.");

                } catch (IOException e) {
                    System.err.println("❗ Error with client: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("❗ Server startup failed: " + e.getMessage());
        }
    }
}
