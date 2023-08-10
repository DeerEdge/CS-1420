package lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Filters for 5-letter words and writes to an out file
 */
public class FilterWords {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("words.txt"));
             PrintWriter outFile = new PrintWriter("five.txt");)
        {
            // Checks if word is present and prints it out word if 5 letters and writes out
            while (in.hasNext()) {
                String word;
                word = in.next();

                if (word.length() == 5) {
                    System.out.println(word);
                    outFile.println(word);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not read the words: " + e.getMessage());
            return;  // Exit main now
        }
    }
}
