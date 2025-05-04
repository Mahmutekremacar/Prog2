package de.thws.Lektion18.dritte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class ToUpperCaseWriterTest {

    private ByteArrayOutputStream baos;

    private ToUpperCaseWriter createWriter() {
        baos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(baos);
        return new ToUpperCaseWriter(osw);
    }

    private String getOutput() {
        return baos.toString();
    }

    @Test
    public void writeCharLowercaseTest() {
        try (ToUpperCaseWriter writer = createWriter()) {
            writer.write('a');
            writer.flush();
            assertEquals("A", getOutput());
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }
    }

    @Test
    public void writeCharNonLetterTest() {
        try (ToUpperCaseWriter writer = createWriter()) {
            writer.write('1');
            writer.flush();
            assertEquals("1", getOutput());
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }
    }

    @Test
    public void asciiLettersToUpperTest() {
        try (ToUpperCaseWriter writer = createWriter()) {
            for (char c = 0; c < 128; c++) {
                writer.write(c);
            }
            writer.flush();
            String output = getOutput();

            for (int i = 0; i < 128; i++) {
                char original = (char) i;
                char expected = (original >= 'a' && original <= 'z') ? Character.toUpperCase(original) : original;
                assertEquals(expected, output.charAt(i), "Fehler bei ASCII-Zeichen: " + (int) original);
            }
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }
    }
}
