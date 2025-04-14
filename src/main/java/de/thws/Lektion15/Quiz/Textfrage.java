package de.thws.Lektion15.Quiz;

public class Textfrage extends Quizfrage {

    public Textfrage(String frage) {
        super(frage);
    }

    @Override
    public String gibAlsText() {
        return frage + "\nAntwort:\n\n";
    }
}

