package de.thws.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void TwoPlusTwo(){
        SimpleCalculator newCalc = new SimpleCalculator();
        assertEquals(4,newCalc.TwoPlusTwo() );
    }

}