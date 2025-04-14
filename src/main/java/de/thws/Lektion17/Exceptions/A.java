package de.thws.Lektion17.Exceptions;

public class A {
    public static void main(String[] args) {
        String s = "abc";
        int zahl = Integer.parseInt(s); // ❌ "abc" ist keine Zahl
    }
    //NumberFormatException
}

