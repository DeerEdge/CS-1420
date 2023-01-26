package assignment03;

/**
 * This class prints out the values from 2^0 through 2^16
 *
 * @author Dheeraj V. Student
 * @version January 23, 2023
 */
public class PowersOfTwo
{
    public static void main(String[] args)
    {
        int value = 1;

        for (int n = 1; n <= 17; n++)
        {
            System.out.println(value); // print updated value
            value = value * 2; // multiply by 2 to represent an increase in the exponent
        }
    }
}
