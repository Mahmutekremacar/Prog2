package de.thws.Lektion17.Exceptions;

import java.io.*;
import java.util.*;

public class ExceptionTester {

    public static void main(String[] args) {

        // a) NumberFormatException
        try {
            String s = "abc";
            int number = Integer.parseInt(s); // kein gültiger Integer
        } catch (NumberFormatException e) {
            System.out.println("a) NumberFormatException: " + e.getMessage());
        }

        // b) ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[3];
            int val = arr[5]; // ungültiger Index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("b) ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // c) NullPointerException
        try {
            String text = null;
            int len = text.length(); // Zugriff auf null
        } catch (NullPointerException e) {
            System.out.println("c) NullPointerException: " + e.getMessage());
        }

        // d) OutOfMemoryError
        try {
            List<int[]> memoryList = new ArrayList<>();
            while (true) {
                memoryList.add(new int[1_000_000]); // zu viel Speicherverbrauch
            }
        } catch (OutOfMemoryError e) {
            System.out.println("d) OutOfMemoryError: " + e.getMessage());
        }

        // e) FileNotFoundException
        try {
            FileReader fr = new FileReader("nicht_vorhanden.txt"); // Datei existiert nicht
        } catch (FileNotFoundException e) {
            System.out.println("e) FileNotFoundException: " + e.getMessage());
        }

        // f) ArithmeticException
        try {
            int result = 10 / 0; // Division durch null
        } catch (ArithmeticException e) {
            System.out.println("f) ArithmeticException: " + e.getMessage());
        }
    }
}
