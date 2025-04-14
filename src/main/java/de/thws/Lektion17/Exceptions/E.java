package de.thws.Lektion17.Exceptions;
//FileNotFoundException
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class E {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader(new File("nicht_existierend.txt")); // ❌ Datei existiert nicht
    }
}
