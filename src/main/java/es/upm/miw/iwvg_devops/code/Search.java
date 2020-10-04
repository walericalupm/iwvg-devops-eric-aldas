package es.upm.miw.iwvg_devops.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    Stream<Double> findDecimalImproperFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.isImproper())
                .map(fraction -> fraction.decimal());
    }

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isProper()))
                .map(User::familyNameInitials);
    }

}
