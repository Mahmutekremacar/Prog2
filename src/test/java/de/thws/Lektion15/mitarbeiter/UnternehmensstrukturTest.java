package de.thws.Lektion15.mitarbeiter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class UnternehmensstrukturTest {

    @Test
    void testGehaltBerechnungAngestellter() {
        Angestellter a = new Angestellter("Meier", "Anna", "A123", 3000.0, LocalDate.of(1990, 1, 1));
        assertEquals(3000.0, a.getGehalt(), 0.01);
    }

    @Test
    void testGehaltBerechnungAbteilungsleiter() {
        Abteilungsleiter l = new Abteilungsleiter("Huber", "Max", "L456", 3000.0, LocalDate.of(1980, 5, 10));
        assertEquals(6000.0, l.getGehalt(), 0.01); // Gehaltsfaktor 2.0
    }

    @Test
    void testBefoerderungErhoehtGehaltsfaktor() {
        Abteilungsleiter l = new Abteilungsleiter("Huber", "Max", "L456", 3000.0, LocalDate.of(1980, 5, 10));
        Angestellter a = new Angestellter("Meier", "Anna", "A123", 3000.0, LocalDate.of(1990, 1, 1));

        l.befoerdern(a);
        assertEquals(1.1, a.getGehaltsfaktor(), 0.0001);
        assertEquals(3300.0, a.getGehalt(), 0.01);
    }

    @Test
    void testAbteilungHatLeiterUndAngestellte() {
        Abteilungsleiter leiter = new Abteilungsleiter("Huber", "Max", "L456", 4000.0, LocalDate.of(1980, 5, 10));
        Abteilung abteilung = new Abteilung("IT", leiter);

        Angestellter a1 = new Angestellter("Meier", "Anna", "A123", 3000.0, LocalDate.of(1990, 1, 1));
        Angestellter a2 = new Angestellter("Schulz", "Paul", "A124", 3200.0, LocalDate.of(1985, 3, 15));

        abteilung.addAngestellter(a1);
        abteilung.addAngestellter(a2);

        assertEquals(2, abteilung.getAngestellte().size());
        assertEquals("L456", abteilung.getLeiter().getId());
    }
}
