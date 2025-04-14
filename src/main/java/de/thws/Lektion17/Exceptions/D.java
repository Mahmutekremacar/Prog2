package de.thws.Lektion17.Exceptions;

//OutOfMemoryError
public class D {
    public static void main(String[] args) {
        int[] riesig = new int[Integer.MAX_VALUE]; // ❌ Sehr großer Speicherbedarf
    }
}
