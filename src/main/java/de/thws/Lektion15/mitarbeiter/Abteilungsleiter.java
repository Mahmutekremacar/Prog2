package de.thws.Lektion15.mitarbeiter;

import java.time.LocalDate;

public class Abteilungsleiter extends Angestellter {

    public Abteilungsleiter(String nachname, String vorname, String id, double grundgehalt, LocalDate geburtsdatum) {
        super(nachname, vorname, id, grundgehalt, geburtsdatum);
        this.gehaltsfaktor = 2.0;
    }

    public void befoerdern(Angestellter a) {
        a.gehaltsfaktor *= 1.10; // +10%
    }
}

