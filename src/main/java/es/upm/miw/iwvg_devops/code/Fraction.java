package es.upm.miw.iwvg_devops.code;

/***
 * Author: Eric Aldas
 * Based in: miw-upm/iwvg-devops project
 *
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() { return this.numerator<this.denominator; }

    public boolean isImproper() { return this.numerator>this.denominator; }

    public boolean isEquivalent(Fraction fraction1, Fraction fraction2)
    {
        return ((fraction1.getNumerator()*fraction2.getDenominator())
                ==
                (fraction1.getDenominator()*fraction2.getNumerator()));
    }

    public Fraction add(Fraction fraction1, Fraction fraction2)
    {
        int leastCommonMultiple = this.getLeastCommonMultiple(fraction1.getDenominator(), fraction2.getDenominator());
        int summand1 = (leastCommonMultiple/fraction1.getDenominator())*fraction1.getNumerator();
        int summand2 = (leastCommonMultiple/fraction2.getDenominator())*fraction2.getNumerator();
        return new Fraction((summand1+summand2), leastCommonMultiple);
    }

    public Fraction multiply(Fraction fraction1, Fraction fraction2) {
        return new Fraction(
                (fraction1.getNumerator() * fraction2.getNumerator()),
                (fraction1.getDenominator()*fraction2.getDenominator())
        );
    }

    public Fraction divide(Fraction fraction1, Fraction fraction2) {
        return new Fraction(
                (fraction1.getNumerator() * fraction2.getDenominator()),
                (fraction1.getDenominator() * fraction2.getNumerator())
        );
    }

    public int getLeastCommonMultiple(int denominatorFraction1, int denominatorFraction2)
    {
        int lcm=1;
        int i=2;
        while(i <= denominatorFraction1 || i <= denominatorFraction2)
        {
            if(denominatorFraction1%i==0 || denominatorFraction2%i==0)
            {
                lcm=lcm*i;
                if(denominatorFraction1%i==0) denominatorFraction1=denominatorFraction1/i;
                if(denominatorFraction2%i==0) denominatorFraction2=denominatorFraction2/i;
            }
            else
                i=i+1;
        }
        return lcm;
    }



    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}