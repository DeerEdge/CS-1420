package assignment02;

import java.util.Scanner;

/**
 * This class prints out the area of a circle using an inputted radius
 *
 * @author Dheeraj V. Student
 * @version January 20, 2023
 */
public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create a Scanner
        System.out.print("Enter the radius of the circle: ");

        double radius = input.nextDouble(); // read input for radius
        double area = Math.PI * radius * radius; // calculate area using the formula for the area of a circle

        System.out.print("The area of the circle is: " + area);
    }
}
