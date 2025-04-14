package de.thws.Lektion15.person;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    void testAusgaben() {
        // Output abfangen
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // Test 1: Student
        new Student("Programmieren").gibTaetigkeitAus();
        String studentOutput = out.toString().trim(); // trim entfernt \n oder \r\n
        assertEquals("Der Student besucht das Fach Programmieren", studentOutput);
        out.reset();

        // Test 2: Professor
        new Professor("Programmieren").gibTaetigkeitAus();
        String profOutput = out.toString().trim();
        assertEquals("Der Professor unterrichtet Programmieren", profOutput);

        // Wiederherstellen
        System.setOut(originalOut);
    }
}
