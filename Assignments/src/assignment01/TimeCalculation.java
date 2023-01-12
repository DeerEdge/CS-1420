package assignment01;

/**
 * This class prints out the equivalent amount of hours, minutes, and seconds using a uID number as the total number of
 * seconds.
 *
 * @author Dheeraj V. Student
 * @version January 12, 2023
 */
public class TimeCalculation
{
    public static void main(String[] args)
    {
        int uID = 1343105; // Declare uID

        System.out.print("My uID number is u");
        System.out.print(uID);
        System.out.println(".");

        int totalHours = uID / 3600;
        int totalMinutes = (uID % 3600) / 60;
        int totalSeconds = (uID % 3600) % 60;

        System.out.print(uID);
        System.out.print(" seconds is ");
        System.out.print(totalHours);
        System.out.print(" hours(s), ");
        System.out.print(totalMinutes);
        System.out.print(" minutes(s), and ");
        System.out.print(totalSeconds);
        System.out.print(" second(s).");
    }
}
