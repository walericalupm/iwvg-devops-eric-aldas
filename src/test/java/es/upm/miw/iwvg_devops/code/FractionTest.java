package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fractionToTest;
    private Fraction fraction2ToTest;
    private Fraction fraction3ToTest;

    @BeforeEach
    void before() {
        this.fractionToTest = new Fraction(1,2);
        this.fraction2ToTest = new Fraction(5,3);
        this.fraction3ToTest = new Fraction(2,4);
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

    @Test
    void isProper() {
        assertEquals(true, this.fractionToTest.isProper());
    }
    @Test
    void isNotProper() {
        assertEquals(false, this.fraction2ToTest.isProper());
    }

    @Test
    void isNotImproper() {
        assertEquals(false, this.fractionToTest.isImproper());
    }
    @Test
    void isImproper() {
        assertEquals(true, this.fraction2ToTest.isImproper());
    }

    @Test
    void isNotEquivalent() {
        assertEquals(false, this.fractionToTest.isEquivalent(this.fractionToTest, this.fraction2ToTest));
    }
    @Test
    void isEquivalent() {
        assertEquals(true, this.fractionToTest.isEquivalent(this.fractionToTest, this.fraction3ToTest));
    }

    @Test
    void add() {
        Fraction correctSumFraction = new Fraction(13,6);
        Fraction sumFraction = this.fractionToTest.add(
                this.fractionToTest,
                this.fraction2ToTest
        );
        boolean isAdditionCorrect = (sumFraction.getNumerator() == correctSumFraction.getNumerator() &&
                sumFraction.getDenominator() == correctSumFraction.getDenominator()) ?
                true :
                false;
        assertEquals(true,isAdditionCorrect);
    }

    @Test
    void multiply() {
        Fraction correctMultiplyFraction = new Fraction(5,6);
        Fraction multiplyFraction = this.fractionToTest.multiply(
                this.fractionToTest,
                this.fraction2ToTest
        );
        boolean isAdMultiplyCorrect = (multiplyFraction.getNumerator() == correctMultiplyFraction.getNumerator() &&
                multiplyFraction.getDenominator() == correctMultiplyFraction.getDenominator()) ?
                true :
                false;
        assertEquals(true,isAdMultiplyCorrect);
    }

    @Test
    void divide() {
        Fraction correctDivideFraction = new Fraction(4,4);
        Fraction divideFraction = this.fractionToTest.divide(
                this.fractionToTest,
                this.fraction3ToTest
        );
        boolean isDivideCorrect = (divideFraction.getNumerator() == correctDivideFraction.getNumerator() &&
                divideFraction.getDenominator() == correctDivideFraction.getDenominator()) ?
                true :
                false;
        assertEquals(true,isDivideCorrect);
    }

    @Test
    void getLeastCommonMultiple() {
        assertEquals(6, this.fractionToTest.getLeastCommonMultiple(
                this.fractionToTest.getDenominator(),
                this.fraction2ToTest.getDenominator()
        ));
    }
}