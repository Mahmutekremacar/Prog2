package de.thws.Lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StreckeTest {

    @Test
    void testKonstruktorReihenfolge() {
        Strecke s = new Strecke(5, 3); // Eingabe in falscher Reihenfolge
        assertEquals(3, s.getA());
        assertEquals(5, s.getB());
    }

    @Test
    void testKeineUeberschneidung() {
        Strecke s1 = new Strecke(1, 3);
        Strecke s2 = new Strecke(3, 5);
        assertFalse(s1.ueberschneidet(s2)); // Berührung zählt nicht
    }

    @Test
    void testUeberschneidungInnen() {
        Strecke s1 = new Strecke(2, 6);
        Strecke s2 = new Strecke(4, 8);
        assertTrue(s1.ueberschneidet(s2));
    }

    @Test
    void testUeberschneidungTeilweise() {
        Strecke s1 = new Strecke(1, 5);
        Strecke s2 = new Strecke(4, 10);
        assertTrue(s1.ueberschneidet(s2));
    }

    @Test
    void testToStringGleichePunkte() {
        Strecke s = new Strecke(4, 4);
        assertEquals("4", s.toString());
    }

    @Test
    void testToStringKurzeStrecke() {
        Strecke s = new Strecke(3, 5);
        assertEquals("3--5", s.toString());
    }

    @Test
    void testToStringLangeStrecke() {
        Strecke s = new Strecke(2, 8);
        assertEquals("2------8", s.toString());
    }
}
