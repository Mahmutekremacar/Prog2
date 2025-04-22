package de.thws.Lektion18.erste;

import java.io.*;

public class Main {
    public static void main(String[] args) throws MatrikelNummerException, IOException {
        String pfad = "quelldatei.txt";
        Studiengangssplitter.splitStudiengaenge(pfad);


    }
}

