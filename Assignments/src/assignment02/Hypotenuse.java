package assignment02;

import java.util.Scanner;

/**
 * This class computes the hypotenuse of a right triangle given the length of two sides
 *
 * @author Dheeraj V. Student
 * @version January 20, 2023
 */
public class Hypotenuse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create a Scanner
        System.out.print("Enter the side length of leg a: ");
        double sideLengthA = input.nextDouble(); // read input for the side length of leg a

        System.out.print("Enter the side length of leg b: ");
        double sideLengthB = input.nextDouble(); // read input for the side length of leg b

        double hypotenuse = Math.sqrt(sideLengthA * sideLengthA + sideLengthB * sideLengthB); // calculate the hypotenuse length

        System.out.print("The length of the hypotenuse is: " + hypotenuse);
    }
}
