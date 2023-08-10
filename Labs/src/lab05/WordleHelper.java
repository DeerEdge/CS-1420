package lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that constructs methods that will aid in the behavior of the created wordle game
 */
public class WordleHelper {
    /**
     * Given a filename, this method returns a count of the number of
     * words in the file.  (Note that word length is not checked here.)
     *
     * @param filename the name of an existing text file
     * @return the count of words in the file
     */
    public static int countWords (String filename) {
        int wordCount = 0;

        try {
            Scanner in = new Scanner(new File(filename));
            // Iterate through and count number of words
            while (in.hasNext()) {
                wordCount++;
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        return wordCount;
    }

    /**
     * This method returns a copy of the input String, but with the
     * character at the specified position changed to the given letter.
     * Position must be a valid position in the String or the results
     * are undefined.
     *
     * Note that this function does not alter the original String, it
     * just returns a copy with a letter replaced.  Here is an example
     * of how this method can be used.
     *
     * word = replaceLetter(word, 1, 'a');
     *
     * If word originally contained "put", the word would now contain
     * "pat".
     *
     *
     * @param s any non-empty string
     * @param position a valid position in the string
     * @param letter a letter to put in the string
     * @return a copy of the original string, with a letter replaced
     */
    public static String replaceLetter(String s, int position, char letter)
    {
        return s.substring(0,position) + letter + s.substring(position+1, s.length());
    }
}
