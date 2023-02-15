package lab06;

/**
 * This class tests the methods defined in the Fraction class
 *
 * @author Dheeraj V. Student
 * @version February 14, 2023
 */
public class FractionTester {
    public static void main(String[] args) {
        Fraction f = new Fraction (2, 3);
        Fraction g = new Fraction (1, 4);
        Fraction h = new Fraction (5, 1);

        System.out.println ("Fraction f contains: " + f);
        System.out.println ("Fraction g contains: " + g);
        System.out.println ("Fraction h contains: " + h);

        System.out.println ("F's numerator is: " + f.getNumerator());
        System.out.println ("F's denominator is: " + f.getDenominator());

        Fraction multiFrac = f.multiply(g);
        System.out.println ("Left hand side: " + f + " Right hand side: " + g + " Multiplied result: " + multiFrac);

        Fraction divFrac = f.divide(g);
        System.out.println ("Left hand side: " + f + " Right hand side: " + g + " Divided result: " + divFrac);

    }
}
