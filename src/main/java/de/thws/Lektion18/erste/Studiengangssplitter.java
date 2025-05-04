package de.thws.Lektion18.erste;

import java.nio.file.*;
import java.io.*;

public class Studiengangssplitter {

    public static void  splitStudiengaenge(String dateiname) throws IOException,MatrikelNummerException
    {
        Path baseDir = Paths.get("Prog2","src","main","java","de","thws","Lektion18","erste");

        Files.createDirectories(baseDir);
        System.out.println("Datei wird gespeichert unter: " + baseDir.toAbsolutePath());

//        BufferedReader reader = new BufferedReader(new FileReader(dateiname));
        BufferedReader reader = Files.newBufferedReader(baseDir.resolve("quelldatei.txt"));
        BufferedWriter winfWriter = Files.newBufferedWriter(baseDir.resolve("WInfNr.txt"));
        BufferedWriter infWriter = Files.newBufferedWriter(baseDir.resolve("InfNr.txt"));
        BufferedWriter ecWriter = Files.newBufferedWriter(baseDir.resolve("ECNr.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            try {
                int matrikelnummer = Integer.parseInt(line.trim());

                if (matrikelnummer >= 5000000 && matrikelnummer <= 5099999) {
                    winfWriter.write(line);
                    winfWriter.newLine();
                } else if (matrikelnummer >= 5100000 && matrikelnummer <= 5199999) {
                    infWriter.write(line);
                    infWriter.newLine();
                } else if (matrikelnummer >= 6100000 && matrikelnummer <= 6199999) {
                    ecWriter.write(line);
                    ecWriter.newLine();
                } else {
                    //throw new MatrikelNummerException("Ungültige Matrikelnummer: " + line);
                    System.err.println("Ungültige Matrikelnummer (außerhalb gültiger Bereiche): " + line);
                }
            } catch (NumberFormatException e) {
                //throw new MatrikelNummerException("Kein gültiger Zahlenwert: " + line);
                System.err.println("Kein gültiger Zahlenwert: " + line);
            }
        }


        reader.close();
        winfWriter.close();
        infWriter.close();
        ecWriter.close();
    }


}
