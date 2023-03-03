package assignment06;

/**
 * This class tests the methods defined in the Fraction class
 *
 * @author Dheeraj V. Student
 * @version February 14, 2023
 */
public class FractionTester {
    public static void main(String[] args) {
        Fraction f = new Fraction (2, 3);
        Fraction g = new Fraction (2, 4);
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

        // Tests to check the behavior of Fraction class methods
        boolean errorFlag = false;

        // Test multiplication
        Fraction a = new Fraction (2, 3);
        Fraction b = new Fraction (1, 5);
        Fraction c = a.multiply(b);
        System.out.println (a + " * " + b + " = " + c);
        if (a.getNumerator() != 2 || a.getDenominator() != 3 ||
                b.getNumerator() != 1 || b.getDenominator() != 5 ||
                c.getNumerator() != 2 || c.getDenominator() != 15)
        {
            System.out.println("Error - multiply did not complete correctly.");
            errorFlag = true;
        }
        if (c.toDouble() != (double) 2/15)
        {
            System.out.println("Error - toDouble after multiplication did not match correctly.");
            errorFlag = true;
        }

        // Test division
        Fraction i = new Fraction (2, 3);
        Fraction j = new Fraction (1, 5);
        Fraction k = i.divide(j);
        System.out.println (i + " / " + j + " = " + k);
        if (i.getNumerator() != 2 || i.getDenominator() != 3 ||
                j.getNumerator() != 1 || j.getDenominator() != 5 ||
                k.getNumerator() != 10 || k.getDenominator() != 3)
        {
            System.out.println("Error - divide did not complete correctly.");
            errorFlag = true;
        }
        if (k.toDouble() != (double) 10/3)
        {
            System.out.println("Error - toDouble after division did not match correctly.");
            errorFlag = true;
        }

        // Test addition
        Fraction l = new Fraction (2, 3);
        Fraction m = new Fraction (1, 5);
        Fraction n = l.add(m);
        System.out.println (l + " + " + m + " = " + n);
        if (l.getNumerator() != 2 || l.getDenominator() != 3 ||
                m.getNumerator() != 1 || m.getDenominator() != 5 ||
                n.getNumerator() != 13 || n.getDenominator() != 15)
        {
            System.out.println("Error - add did not complete correctly.");
            errorFlag = true;
        }
        if (n.toDouble() != (double) 13/15)
        {
            System.out.println("Error - toDouble after addition did not match correctly.");
            errorFlag = true;
        }

        // Test subtraction
        Fraction o = new Fraction (2, 3);
        Fraction p = new Fraction (1, 5);
        Fraction q = l.subtract(m);
        System.out.println (o + " - " + p + " = " + q);
        if (o.getNumerator() != 2 || o.getDenominator() != 3 ||
                p.getNumerator() != 1 || p.getDenominator() != 5 ||
                q.getNumerator() != 7 || q.getDenominator() != 15)
        {
            System.out.println("Error - subtract did not complete correctly.");
            errorFlag = true;
        }
        if (q.toDouble() != (double) 7/15)
        {
            System.out.println("Error - toDouble after subtraction did not match correctly.");
            errorFlag = true;
        }

        // Check if any errors occurred after running all the tests
        if (errorFlag)
        {
            System.out.println("All tests completed, errors found.");
        }
        else
        {
            System.out.println("All tests completed, no errors.");
        }
    }
}
