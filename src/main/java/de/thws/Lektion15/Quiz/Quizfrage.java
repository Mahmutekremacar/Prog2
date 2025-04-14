package de.thws.Lektion15.Quiz;

public abstract class Quizfrage {
    protected String frage;

    public Quizfrage(String frage) {
        this.frage = frage;
    }

    public abstract String gibAlsText();
}

