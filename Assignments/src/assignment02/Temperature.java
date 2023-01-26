package assignment02;

import java.util.Scanner;

/**
 * This class converts a given Fahrenheit temperature to a Celsius temperature
 *
 * @author Dheeraj V. Student
 * @version January 20, 2023
 */
public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create a Scanner
        System.out.print("Enter the temperature in Fahrenheit: ");
        int temperatureInF = input.nextInt(); // read input for the temperature in Fahrenheit

        int temperatureInC = 5 * (temperatureInF - 32) / 9; // compute temperature in Celsius

        System.out.print("The temperature in Celsius is: " + temperatureInC);
    }
}
