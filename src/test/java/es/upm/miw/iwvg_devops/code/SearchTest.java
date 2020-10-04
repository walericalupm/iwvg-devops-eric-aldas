package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void findHighestFraction() {
        assertEquals(new Fraction(2,1).decimal(),new Search().findHighestFraction().decimal());
    }
}