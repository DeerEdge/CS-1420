package assignment03;

import java.util.Scanner;

/**
 * This class prints out the values from 2^0 through 2^16
 *
 * @author Dheeraj V. Student
 * @version January 25, 2023
 */
public class HailstoneSearch
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // read input
        System.out.print("Enter a number: ");

        int x = input.nextInt();
        while (x < 1) // ensures that the iteration number provided is greater than or equal to 1
        {
            System.out.print("Incorrect input. Enter a valid number: ");
            x = input.nextInt();
        }

        int n = 2; // the current number in which the count of iterations is checked
        int number = 2; // a copy of variable n which is evaluated by the Hailstone algorithm
        int iterations = 0; // initialize iteration counter to 0

        while (n != 1000) // ints in set [2...1000) are checked
        {
            while (number != 1) // performs the Hailstone protocol until 1 is reached
            {
                if (number % 2 == 0)
                {
                    number = number / 2;
                }
                else
                {
                    number = number * 3 + 1;
                }
                iterations = iterations + 1;
            }

            // if there is a match between the inputted iteration value between user and the evaluated integer,
            // then the loop is broken and N is printed with the number of iterations
            if (iterations == x)
            {
                System.out.println("The Hailstone sequence starting at " + n + " takes " + iterations + " steps to converge to 1.");
                break;
            }

            iterations = 0;
            n = n + 1;
            number = n;
        }
    }
}
