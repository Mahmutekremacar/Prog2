package de.thws.Lektion14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KugelvolumenTest {

    @Test
    void testBerechneKugelvolumen() {
        // Radius: 0
        assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(0), 0.0001);

        // Radius: 1 → V = 4/3 * π ≈ 4.18879
        assertEquals(4.18879, Kugelvolumen.berechneKugelvolumen(1), 0.0001);

        // Radius: 5 → V = 4/3 * π * 125 ≈ 523.5988
        assertEquals(523.5988, Kugelvolumen.berechneKugelvolumen(5), 0.0001);



            assertThrows(IllegalArgumentException.class, () -> {
                Kugelvolumen.berechneKugelvolumen(-1);
            });

    }

}