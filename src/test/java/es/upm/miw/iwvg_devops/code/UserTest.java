package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

class UserTest{

    private User userToTest;
    private List<Fraction> fractionsList;


    @BeforeEach
    void before() {
        fractionsList = new ArrayList<>();
        fractionsList.add(new Fraction(1,2));
        fractionsList.add(new Fraction(5,3));
        fractionsList.add(new Fraction(4,9));
        this.userToTest = new User("1", "Eric", "Aldas", fractionsList);
    }

    @Test
    void getId() {
        assertEquals("1", this.userToTest.getId());
    }

    @Test
    void getName() {
        assertEquals("Eric", this.userToTest.getName());
    }

    @Test
    void setName() {
        this.userToTest.setName("Walter");
        assertEquals("Walter", this.userToTest.getName());
    }

    @Test
    void getFamilyName() {
        assertEquals("Eric", this.userToTest.getName());
    }

    @Test
    void setFamilyName() {
        this.userToTest.setName("Arguello");
        assertEquals("Arguello", this.userToTest.getName());
    }

    @Test
    void getFractions() {
        assertEquals(3, this.userToTest.getFractions().size());
    }

    @Test
    void setFractions() {
        List<Fraction> newFractionsList = new ArrayList<>();
        newFractionsList.add(new Fraction(6,5));
        this.userToTest.setFractions(newFractionsList);

        assertEquals(1, this.userToTest.getFractions().size());

    }

    @Test
    void addFraction() {
        this.userToTest.addFraction(new Fraction(6,9));
        assertEquals(4, this.userToTest.getFractions().size());
    }

    @Test
    void fullName() {
        assertEquals("Eric Aldas", this.userToTest.fullName());
    }

    @Test
    void initials() {
        assertEquals("E.A", this.userToTest.initials());
    }


}