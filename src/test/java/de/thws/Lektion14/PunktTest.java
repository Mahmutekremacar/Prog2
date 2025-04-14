package de.thws.Lektion14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PunktTest {

    @Test
    void testGelingenfall() {
        Punkt p = new Punkt();
        p.verschiebePunkt(100, 200);
        assertEquals(100, p.getX());
        assertEquals(200, p.getY());
    }

    @Test
    void testNegativeXKoordinate() {
        Punkt p = new Punkt();
        assertThrows(RuntimeException.class, () -> p.verschiebePunkt(-1, 100));
    }

    @Test
    void testNegativeYKoordinate() {
        Punkt p = new Punkt();
        assertThrows(RuntimeException.class, () -> p.verschiebePunkt(100, -1));
    }

    @Test
    void testXGroesserAls1920() {
        Punkt p = new Punkt();
        assertThrows(RuntimeException.class, () -> p.verschiebePunkt(1921, 100));
    }

    @Test
    void testYGroesserAls1080() {
        Punkt p = new Punkt();
        assertThrows(RuntimeException.class, () -> p.verschiebePunkt(100, 1081));
    }
}