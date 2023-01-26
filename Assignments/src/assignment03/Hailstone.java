package assignment03;

import java.util.Scanner;

/**
 * This class prints out the values from 2^0 through 2^16
 *
 * @author Dheeraj V. Student
 * @version January 25, 2023
 */
public class Hailstone
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // read input
        System.out.print("Enter a number: ");

        int number = input.nextInt();
        while (number < 1) // repeatedly ask for input until input is larger than or equal to 1
        {
            System.out.print("Incorrect input. Enter a valid number: ");
            number = input.nextInt();
        }

        System.out.print(number + " ");
        int iterations = 0; // initialize iteration counter to 0

        while (number != 1) // the Hailstone protocol will run until the number evaluates to 1
        {
            if (number % 2 == 0)
            {
                number = number / 2; // if the number is even, it is divided by 2
            }
            else
            {
                number = number * 3 + 1; // if the number is odd, it is multiplied by 3 and summed by 1
            }

            System.out.print(number + " ");
            iterations = iterations + 1; // counter updates
        }

        System.out.println();
        System.out.print("Total number of iterations taken to converge to 1: " + iterations);
    }
}
