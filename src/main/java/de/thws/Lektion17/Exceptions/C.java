package de.thws.Lektion17.Exceptions;
//NullPointerException
public class C {
    public static void main(String[] args) {
        String s = null;
        int laenge = s.length(); // ❌ s ist null
    }
}

