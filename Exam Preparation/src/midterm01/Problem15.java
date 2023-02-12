package midterm01;

import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputCount = 0;
        int sum = 0;
        while (inputCount < 5) {
            int number = input.nextInt();
            sum = sum + number;
            inputCount++;
        }
        System.out.println(sum);
    }
}
