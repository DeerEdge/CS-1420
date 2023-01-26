package assignment02;

import java.util.Scanner;

/**
 * This class converts an integer to eight-bit-binary
 *
 * @author Dheeraj V. Student
 * @version January 20, 2023
 */
public class Binary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create a Scanner
        System.out.print("Enter a number: ");
        int number = input.nextInt(); // read input for an integer

        // Get the result of base division by 2
        int binary128 = number;
        int binary64 = binary128/2;
        int binary32 = binary64/2;
        int binary16 = binary32/2;
        int binary8 = binary16/2;
        int binary4 = binary8/2;
        int binary2 = binary4/2;
        int binary1 = binary2/2;

        // Check oddity of integers to determine its binary value and print
        System.out.print("The decimal number " + number + " is " + (binary1 % 2) + (binary2 % 2) + (binary4 % 2) +
                (binary8 % 2) + (binary16 % 2) + (binary32 % 2) + (binary64 % 2) + (binary128 % 2) + " in binary.");
    }
}
