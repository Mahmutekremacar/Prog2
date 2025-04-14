package de.thws.Lektion14;

public class Person {
    private String vorname;
    private String nachname;
    private Adresse adresse;

    public Person(String vorname, String nachname, Adresse adresse) {
        if (!Character.isUpperCase(vorname.charAt(0))) {
            throw new RuntimeException("Vorname muss mit einem Großbuchstaben beginnen.");
        }
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }

    // Optional: Getter
    public String getVorname() { return vorname; }
    public String getNachname() { return nachname; }
    public Adresse getAdresse() { return adresse; }
}
class Adresse {
    private String strasse;
    private String hausnummer;
    private String postleitzahl;
    private String ort;

    public Adresse(String strasse, String hausnummer, String postleitzahl, String ort) {
        if (!Character.isUpperCase(strasse.charAt(0))) {
            throw new RuntimeException("Straße muss mit einem Großbuchstaben beginnen.");
        }
        if (!Character.isDigit(hausnummer.charAt(0))) {
            throw new RuntimeException("Hausnummer muss mit einer Ziffer beginnen.");
        }
        if (!Character.isUpperCase(ort.charAt(0))) {
            throw new RuntimeException("Ort muss mit einem Großbuchstaben beginnen.");
        }

        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }

    // Optional: Getter
    public String getStrasse() { return strasse; }
    public String getHausnummer() { return hausnummer; }
    public String getPostleitzahl() { return postleitzahl; }
    public String getOrt() { return ort; }
}

