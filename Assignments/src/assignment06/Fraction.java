package assignment06;

/**
 * This class defines the behavior and methods of the Fraction object
 *
 * @author Dheeraj V. Student
 * @version February 14, 2023
 */
public class Fraction {
    private long numerator;
    private long denominator;

    /**
     * This method initializes the values of a created Fraction object with a whole number
     * @param n is a long representing the numerator value
     */
    public Fraction (long n)
    {
        numerator = n;
        denominator = 1;
    }

    /**
     * This method initializes the values of a created Fraction object
     * @param n is a long representing the numerator value
     * @param d is a long representing the denominator value
     */
    public Fraction (long n, long d)
    {
        long gcd = n;
        long remainder = d;

        while (remainder != 0)
        {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }

        numerator = n/gcd;
        denominator = d/gcd;

        if(denominator < 0)
        {
            numerator = -numerator;
            denominator = -denominator;
        }

        System.out.println ("Fraction constructor called with " +
                n + " and " + d + ".");
    }

    /**
     * This method adds two Fraction objects together
     * @param rightHandSide is the Fraction object being added
     * @return a new Fraction object with the result of the summation
     */
    public Fraction add (Fraction rightHandSide)
    {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction ((this.numerator * rightHandSide.denominator + rightHandSide.numerator * this.denominator),
                this.denominator * rightHandSide.denominator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    /**
     * This method subtracts two Fraction objects together
     * @param rightHandSide is the Fraction object being subtracted
     * @return a new Fraction object with the result of the subtraction
     */
    public Fraction subtract (Fraction rightHandSide)
    {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction ((this.numerator * rightHandSide.denominator - rightHandSide.numerator * this.denominator),
                this.denominator * rightHandSide.denominator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    /**
     * This method multiplies two Fraction objects together
     * @param rightHandSide is the Fraction object being multiplied
     * @return a new Fraction object with the result of the multiplication
     */
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

    /**
     * This method divides two Fraction objects together
     * @param rightHandSide is the Fraction object being divided
     * @return a new Fraction object with the result of the division
     */
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

    /**
     * A method that outputs the String representation of the object
     * @return
     */
    public String toString ()
    {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * A method that outputs the object as an approximate decimal value
     * @return
     */
    public double toDouble ()
    {
        double result = (double) this.numerator/this.denominator;
        return result;
    }

    /**
     * Gets the numerator value of a Fraction object
     * @return the long value of the numerator
     */
    public long getNumerator ()
    {
        return numerator;
    }

    /**
     * Gets the denominator value of a Fraction object
     * @return the long value of the denominator
     */
    public long getDenominator ()
    {
        return denominator;
    }
}
