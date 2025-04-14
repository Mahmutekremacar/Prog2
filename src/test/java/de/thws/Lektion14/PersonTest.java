package de.thws.Lektion14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testGelingenfall() {
        Adresse adresse = new Adresse("Hauptstraße", "12A", "12345", "Berlin");
        Person person = new Person("Anna", "Müller", adresse);

        assertEquals("Anna", person.getVorname());
        assertEquals("Berlin", person.getAdresse().getOrt());
    }

    @Test
    void testVornameMitKleinbuchstaben() {
        Adresse adresse = new Adresse("Hauptstraße", "12A", "12345", "Berlin");
        assertThrows(RuntimeException.class, () -> new Person("anna", "Müller", adresse));
    }

    @Test
    void testStrasseMitKleinbuchstaben() {
        assertThrows(RuntimeException.class, () -> new Adresse("nebenstraße", "12A", "12345", "Berlin"));
    }

    @Test
    void testOrtMitKleinbuchstaben() {
        assertThrows(RuntimeException.class, () -> new Adresse("Hauptstraße", "12A", "12345", "hamburg"));
    }

    @Test
    void testHausnummerBeginntNichtMitZiffer() {
        assertThrows(RuntimeException.class, () -> new Adresse("Hauptstraße", "A12", "12345", "Berlin"));
    }
}
