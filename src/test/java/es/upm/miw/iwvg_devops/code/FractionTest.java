package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fractionToTest;

    @BeforeEach
    void before() {
        this.fractionToTest = new Fraction(1,2);
    }

    @Test
    void getNumerator() {
        assertEquals(1, this.fractionToTest.getNumerator());
    }

    @Test
    void setNumerator() {
        this.fractionToTest.setNumerator(3);
        assertEquals(3, this.fractionToTest.getNumerator());
    }

    @Test
    void getDenominator() {
        assertEquals(2, this.fractionToTest.getDenominator());
    }


    @Test
    void setDenominator() {
        this.fractionToTest.setDenominator(5);
        assertEquals(5, this.fractionToTest.getDenominator());
    }

    @Test
    void decimal() {
        assertEquals(0.5, this.fractionToTest.decimal());
    }
}