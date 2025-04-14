package de.thws.Lektion15.mitarbeiter;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Abteilung {
    private String name;
    private Abteilungsleiter leiter;
    private List<Angestellter> angestellte = new ArrayList<>();

    public Abteilung(String name, Abteilungsleiter leiter) {
        this.name = name;
        this.leiter = leiter;
    }

    public void addAngestellter(Angestellter a) {
        angestellte.add(a);
    }

    public List<Angestellter> getAngestellte() {
        return angestellte;
    }

    public Abteilungsleiter getLeiter() {
        return leiter;
    }
}
