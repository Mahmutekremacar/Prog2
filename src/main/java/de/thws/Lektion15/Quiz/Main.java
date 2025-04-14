package de.thws.Lektion15.Quiz;


public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Textfragen
        quiz.fuegeFrageHinzu(new Textfrage("Was ist die Hauptstadt von Deutschland?"));
        quiz.fuegeFrageHinzu(new Textfrage("Wie heißt die Programmiersprache, die auf der JVM läuft?"));

        // Multiple-Choice-Fragen
        quiz.fuegeFrageHinzu(new MultipleChoiceFrage(
                "Wie viele Protonen hat ein Wasserstoff-Atom?",
                new String[] {"4", "2", "1", "0"}
        ));

        quiz.fuegeFrageHinzu(new MultipleChoiceFrage(
                "Welche Farbe hat der Himmel bei klarem Wetter?",
                new String[] {"Grün", "Blau", "Gelb", "Rot"}
        ));

        // Quizbogen erzeugen
        String quizbogen = quiz.generiereQuizbogen();
        System.out.println(quizbogen);
    }
}


