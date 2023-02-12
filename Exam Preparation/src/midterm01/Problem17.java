package midterm01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem17{
    public static void main(String[]args) throws IOException {
        File filename = new File("dogs.txt");
        Scanner file = new Scanner(filename);

        int total = 0;
        int count = 0;
        while (file.hasNextInt()) {
            count++;
            total = total + file.nextInt();
        }
        System.out.println(total);
    }
}
