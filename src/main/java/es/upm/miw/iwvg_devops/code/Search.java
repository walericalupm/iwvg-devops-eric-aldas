package es.upm.miw.iwvg_devops.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Search {

    public Fraction findHighestFraction() {
        Integer maxDenominator = 0;
        //Get All positive fractions
        ArrayList<Fraction> fractions = (ArrayList<Fraction>) new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions()
                        .stream())
                .filter(fraction -> fraction.getDenominator() > 0)
                .collect(Collectors.toList());

        //Calculate same denominator
        maxDenominator = fractions.stream().map(Fraction::getDenominator)
                .collect(Collectors.toList())
                .stream()
                .reduce(1, (a, b) -> a * b);

        Integer finalMaxDenominator = maxDenominator;

        //Transform all fractions with same denominator
        fractions.stream().forEach(fraction -> fraction.setNumerator((finalMaxDenominator / fraction.getDenominator()) * fraction.getNumerator()));
        fractions.stream().forEach(fraction -> fraction.setDenominator(finalMaxDenominator));

        //Get highest numerator (is the max fraction)
        Integer maxNumerator = fractions.stream().map(Fraction::getNumerator).collect(Collectors.toList())
                .stream()
                .max(Comparator.naturalOrder())
                .get();

        return new Fraction(maxNumerator, finalMaxDenominator);
    }
}
