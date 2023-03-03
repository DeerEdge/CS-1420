package assignment06;

import java.util.Scanner;

public class FractionRoot {
    public static void main(String[] args) {
        // Take numerator, denominator, and approximation count inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the numerator of your fraction: ");
        long numerator = input.nextLong();
        System.out.print("Enter the denominator of your fraction: ");
        long denominator = input.nextLong();
        System.out.print("Enter approximation count: ");
        int Z = input.nextInt();

        // Create user's fraction
        Fraction userFraction = new Fraction(numerator, denominator);

        // Set first term to be half of the user's fraction
        Fraction currentX = userFraction.multiply(new Fraction(1,2));
        Fraction nextX;

        // Use the iterative formula to approximate the square root after Z iterations
        for( int i = 0; i < Z; i++)
        {
            nextX = (currentX.add(userFraction.divide(currentX))).multiply(new Fraction(1,2));
            currentX = nextX;
        }

        System.out.println("The square root of " + userFraction + " is approximately " + currentX + ".");
    }
}
