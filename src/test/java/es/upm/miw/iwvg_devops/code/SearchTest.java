package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void findHighestFraction() {
        assertEquals(new Fraction(2, 1).decimal(), new Search().findHighestFraction().decimal());
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(new Fraction(2, 1).decimal(),
                new Fraction(4, 3).decimal()),
                new Search().findDecimalImproperFractionByUserName("Ana")
                        .collect(Collectors.toList()));
    }

    @Test
    void findUserFamilyNameInitialBySomeProperFraction() {
        assertEquals(List.of("F", "B","L","B"), new Search().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }
}