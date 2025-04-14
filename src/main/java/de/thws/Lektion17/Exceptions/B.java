package de.thws.Lektion17.Exceptions;

//ArrayIndexOutOfBoundsException

public class B {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int fehler = arr[5]; // ❌ Index 5 existiert nicht
    }
}

