package de.thws.Lektion15.Quiz;


public class MultipleChoiceFrage extends Quizfrage {
    private String[] antworten;

    public MultipleChoiceFrage(String frage, String[] antworten) {
        super(frage);
        this.antworten = antworten;
    }

    @Override
    public String gibAlsText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fragentext:\n").append(frage).append("\nAntwortmöglichkeiten:\n");
        char buchstabe = 'A';
        for (String antwort : antworten) {
            sb.append(buchstabe++).append(": ").append(antwort).append("\n");
        }
        return sb.toString();
    }
}
