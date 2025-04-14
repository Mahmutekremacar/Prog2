package de.thws.Lektion15.mitarbeiter;

import java.time.LocalDate;

public class Angestellter {
    private String nachname;
    private String vorname;
    private String id;
    private double grundgehalt;
    protected double gehaltsfaktor = 1.0;
    private LocalDate geburtsdatum;

    public Angestellter(String nachname, String vorname, String id, double grundgehalt, LocalDate geburtsdatum) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.id = id;
        this.grundgehalt = grundgehalt;
        this.geburtsdatum = geburtsdatum;
    }

    public double getGehalt() {
        return grundgehalt * gehaltsfaktor;
    }

    public double getGehaltsfaktor() {
        return gehaltsfaktor;
    }

    public String getId() {
        return id;
    }
}
