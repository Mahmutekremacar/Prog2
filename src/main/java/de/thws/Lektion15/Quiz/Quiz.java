package de.thws.Lektion15.Quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Quizfrage> fragen = new ArrayList<>();

    public void fuegeFrageHinzu(Quizfrage frage) {
        fragen.add(frage);
    }

    public String generiereQuizbogen() {
        StringBuilder sb = new StringBuilder();
        for (Quizfrage frage : fragen) {
            sb.append(frage.gibAlsText()).append("\n");
        }
        return sb.toString();
    }
}

