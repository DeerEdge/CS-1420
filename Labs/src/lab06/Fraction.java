package lab06;

/**
 * This class defines the behavior and methods of the Fraction object
 *
 * @author Dheeraj V. Student
 * @version February 14, 2023
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int n, int d)
    {
        numerator = n;
        denominator = d;
        System.out.println ("Fraction constructor called with " +
                n + " and " + d + ".");
    }

    public Fraction multiply (Fraction rightHandSide)
    {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.numerator,
                this.denominator * rightHandSide.denominator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    public Fraction divide (Fraction rightHandSide)
    {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.denominator,
                this.denominator * rightHandSide.numerator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    public String toString ()
    {
        return this.numerator + "/" + this.denominator;
    }

    public int getNumerator ()
    {
        return numerator;
    }

    public int getDenominator ()
    {
        return denominator;
    }
}
