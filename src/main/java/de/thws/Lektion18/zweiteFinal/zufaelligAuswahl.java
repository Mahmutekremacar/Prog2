package de.thws.Lektion18.zweiteFinal;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class zufaelligAuswahl {

    public static char[] getRandomWordAsCharArray(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        if (lines.isEmpty()) {
            throw new IOException("The file is empty!");
        }

        Random random = new Random();
        String randomWord = lines.get(random.nextInt(lines.size())).trim();

        return randomWord.toCharArray();  // ✅ turn string into char array
    }

    public static void main(String[] args) {
        try {
            char[] word = getRandomWordAsCharArray("words.txt");

            System.out.println("Random word as char array:");
            System.out.println(Arrays.toString(word));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

