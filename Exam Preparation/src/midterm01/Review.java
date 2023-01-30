package midterm01;

public class Review
{
    public static void main(String[] args)
    {
        /* Task 1 - Primitive types

            float -> 12F
            int -> -15
            "Hello" -> String
            42.0 -> double
            'A' -> String
            long -> long
            true -> boolean

         */

        /* Task 2,3 - Comments

            // This is a single-line comment

            /(*)
                This is a multi-line comment (remove parentheses in syntax)
            (*)/

        */

        /* Task 4, 5 - Creating and Initializing Variables

            Given an object of type "File", we create a variable as such:
            File name;

            We can create and initialize variables on the same line:
            int level = 9000;
         */

        /* Task 6, 7 - Writing Expressions

            Suppose we are to compute the square root of a variable y:
            Math.sqrt(y)

            To type cast the result:
            (int) Math.sqrt(y)

         */

        // Task 8 completed on paper

        // Task 9 - if vs. while
        int number = 5;

        if (number < 1)
        {
            System.out.println(number + " is less than 1");
        }

        while (number >= 1)
        {
            System.out.println(number + " is greater than 1");
            number = number - 1;
        }
        System.out.println(number + " is less than 1");

        // Following tasks completed on paper
    }
}
