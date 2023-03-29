/*
 * A collection of unit tests for Assignment #7.  To make this work, you'll need to 
 * follow a few steps to get JUnit tests set up in your project.
 * 
 *     Find an @Test annotation above one of the functions below.
 *     It should be in red indicating that JUnit5 is not installed.
 *     Hover over it, and it will suggest JUnit4 along with more options.
 *     Do not install JUnit4.  Instead, look at the additional suggested
 *     options and select to install JUnit5.  Follow the prompts and
 *     JUnit5 will be installed for you.
 *
 *     That's it!  You should not need to adjust dependencies or
 *     install additional tools.  (Installing JUnit5 can be complex,
 *     but the above strategy is simple.)
 *
 *     I've already imported the needed classes (and functions) for
 *     JUnit5 assertions.  See below.
 *
 *  Peter Jensen
 *  
 * Modified by:
 * @author ***Put your name here***
 * @version ***Put the date here***
 */
package assignment07;

import java.awt.*;
import java.util.Arrays;  // OK in tests, not allowed in ArrayExercises
import java.util.List;

// Imports for JUnit 5

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests 
	 * for errors.  The code/test design is up to the programmer.  
	 * 
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library throws an exception and records a failure.
	 * 
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.
		
		int[] result;
		int size = 30;
		
		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
		
		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.
		
		// Make sure the size of the result array is correct.
		
		assertEquals(size, result.length);  // If unequal, an error is recorded.
		
		// Make sure the required numbers [0..n-1] are in the array.
		
		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.
			
			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Found it, continue the outer loop.
			
			// If we get this far, the number n was not found.  This is an error.
			
			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
		}		
		
		// If the number loop completes without failing, all tests pass!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is 
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *   
	 * Because random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error. 
	 *   
	 * I do not expect students to study this code - it is poor code.
	 *   (I don't like the way I'm counting permutations.)  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */ 
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.
		
		// Counts of how many times each permutation appears.
		
		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;
		
		// Repeatedly generate arrays (1,000,000 times).
		
		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.
			
			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
			
			// Keep counts of each permutation in the array.
			
			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}
		
		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.
		
		if (Math.abs(166_666 - count012) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
		
		if (Math.abs(166_666 - count021) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
		
		if (Math.abs(166_666 - count102) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
		
		if (Math.abs(166_666 - count120) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
		
		if (Math.abs(166_666 - count201) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
		
		if (Math.abs(166_666 - count210) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	
	@Test
	public void testReverseOrder01()
	{
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] array = {'a', 'c', 'b', 'e', 'd'};
		ArrayExercises.reverseOrder(array);
		char[] reversedArray = {'d', 'e', 'b', 'c', 'a'};
		assertArrayEquals(array, reversedArray);
	}

	@Test
	public void testReverseOrder02()
	{
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] array = {'d', 'e', 's', 'r', 'e', 'v', 'e', 'r'};
		ArrayExercises.reverseOrder(array);
		char[] reversedArray = {'r', 'e', 'v', 'e', 'r', 's', 'e', 'd'};
		assertArrayEquals(array, reversedArray);
	}

	@Test
	public void testReverseOrder03()
	{
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] array = {'5', '6', '9', '1', '2'};
		ArrayExercises.reverseOrder(array);
		char[] reversedArray = {'2', '1', '9', '6', '5'};
		assertArrayEquals(array, reversedArray);
	}

	@Test
	public void testCount01()
	{
		String[] array = {"a", "a", "a", "b", "b", "c"};
		assertEquals(3, ArrayExercises.count(array, "a"));
	}

	@Test
	public void testCount02()
	{
		String[] array = {"a", "a", "a", "b", "b", "c"};
		assertEquals(2, ArrayExercises.count(array, "b"));
	}

	@Test
	public void testCount03()
	{
		String[] array = {"a", "a", "a", "b", "b", "c"};
		assertEquals(1, ArrayExercises.count(array, "c"));
	}

	@Test
	public void testReplace01()
	{
		String[] array = {"a", "a", "b", "b", null, "c", "d", "e"};
		ArrayExercises.replace(array, "c", "d");
		String[] replacedArray = {"a", "a", "b", "b", null, "d", "d", "e"};
		assertArrayEquals(array, replacedArray);
	}

	@Test
	public void testReplace02()
	{
		String[] array = {"a", "a", "b", "b", "c", "c", "d", "e"};
		ArrayExercises.replace(array, "a", "z");
		String[] replacedArray = {"z", "z", "b", "b", "c", "c", "d", "e"};
		assertArrayEquals(array, replacedArray);
	}


	@Test
	public void testReplace03()
	{
		String[] array = {"a", null, "b", "b", null, "c", null, "e"};
		ArrayExercises.replace(array, "b", "c");
		String[] replacedArray = {"a", null, "c", "c", null, "c", null, "e"};
		assertArrayEquals(array, replacedArray);
	}

	@Test
	public void testComputeAreas01()
	{
		double[] rectangleWidths = {0.0, 5.0, 10.0};
		double[] rectangleHeights = {0.0, 5.0, 10.0};
		double[] rectangleAreas = ArrayExercises.computeAreas(rectangleWidths, rectangleHeights);
		double[] correctAreas = {0.0, 25.0, 100.0};
		assertArrayEquals(rectangleAreas, correctAreas);
	}

	@Test
	public void testComputeAreas02()
	{
		double[] rectangleWidths = {10.0, 20.0, 30.0};
		double[] rectangleHeights = {10.0, 20.0, 30.0};
		double[] rectangleAreas = ArrayExercises.computeAreas(rectangleWidths, rectangleHeights);
		double[] correctAreas = {100.0, 400.0, 900.0};
		assertArrayEquals(rectangleAreas, correctAreas);
	}

	@Test
	public void testComputeAreas03()
	{
		double[] rectangleWidths = {1.0, 2.0, 3.0};
		double[] rectangleHeights = {1.0, 2.0, 3.0};
		double[] rectangleAreas = ArrayExercises.computeAreas(rectangleWidths, rectangleHeights);
		double[] correctAreas = {1.0, 4.0, 9.0};
		assertArrayEquals(rectangleAreas, correctAreas);
	}


	@Test
	public void testRemove01()
	{
		Color[] pixels = {Color.RED, Color.BLUE, null};
		Color[] sortedColors = ArrayExercises.remove(pixels, Color.RED);
		Color[] correctColors = {Color.BLUE, null};
		assertArrayEquals(sortedColors, correctColors);
	}

	@Test
	public void testRemove02()
	{
		Color[] pixels = {Color.RED, Color.YELLOW, null};
		Color[] sortedColors = ArrayExercises.remove(pixels, Color.RED);
		Color[] correctColors = {Color.YELLOW, null};
		assertArrayEquals(sortedColors, correctColors);
	}

	@Test
	public void testRemove03()
	{
		Color[] pixels = {Color.RED, Color.GREEN, null};
		Color[] sortedColors = ArrayExercises.remove(pixels, Color.RED);
		Color[] correctColors = {Color.GREEN, null};
		assertArrayEquals(sortedColors, correctColors);
	}

	@Test
	public void testSort01()
	{
		int[] array = {1, 5, 9, 7};
		int[] sortedArray = {9, 7, 5, 1};
		ArrayExercises.sort(array);
		assertArrayEquals(sortedArray, array);
	}

	@Test
	public void testSort02()
	{
		int[] array = {1, 5, 9, 7, 10, 100, 23, 1, 9};
		int[] sortedArray = {100, 23, 10, 9, 9, 7, 5, 1, 1};
		ArrayExercises.sort(array);
		assertArrayEquals(sortedArray, array);
	}

	@Test
	public void testSort03()
	{
		int[] array = {1, 5, 9, 7, 10, 100, 23};
		int[] sortedArray = {100, 23, 10, 9, 7, 5, 1};
		ArrayExercises.sort(array);
		assertArrayEquals(sortedArray, array);
	}

	@Test
	public void testFindSmallest01()
	{
		Rectangle rectangle1 = new Rectangle(1, 5);
		Rectangle rectangle2 = new Rectangle(4, 4);
		Rectangle rectangle3 = new Rectangle(6, 7);
		Rectangle[] rectangleArray = {rectangle1, rectangle2, rectangle3};
		Rectangle smallestRect = ArrayExercises.findSmallest((rectangleArray));
		Rectangle correctRect = rectangle1;
	}

	@Test
	public void testFindSmallest02()
	{
		Rectangle rectangle1 = new Rectangle(4, 5);
		Rectangle rectangle2 = new Rectangle(1, 4);
		Rectangle rectangle3 = new Rectangle(2, 7);
		Rectangle[] rectangleArray = {rectangle1, rectangle2, rectangle3};
		Rectangle smallestRect = ArrayExercises.findSmallest((rectangleArray));
		Rectangle correctRect = rectangle2;
	}

	@Test
	public void testFindSmallest03()
	{
		Rectangle rectangle1 = new Rectangle(10, 5);
		Rectangle rectangle2 = new Rectangle(42, 4);
		Rectangle rectangle3 = new Rectangle(6, 7);
		Rectangle[] rectangleArray = {rectangle1, rectangle2, rectangle3};
		Rectangle smallestRect = ArrayExercises.findSmallest((rectangleArray));
		Rectangle correctRect = rectangle3;
	}

	@Test
	public void testHistogram01()
	{
		int[] data = {1, 1, 1, 2, 2, 3, 3, 4};
		int[] histogramArray = ArrayExercises.histogram(data);
		int[] correctHistogram = {0, 3, 2, 2, 1};
		assertArrayEquals(correctHistogram, histogramArray);
	}

	@Test
	public void testHistogram02()
	{
		int[] data = {1, 2, 2, 3, 3, 4};
		int[] histogramArray = ArrayExercises.histogram(data);
		int[] correctHistogram = {0, 1, 2, 2, 1};
		assertArrayEquals(correctHistogram, histogramArray);
	}


	/* Note:  You'll want more unit test functions.  Cut-and-paste existing tests, but increase
	 * the number in the function names.  Make sure to include @test before each function header.
	 *
	 * testReverseOrder01
	 * testReverseOrder02
	 * testReverseOrder03  ...etc...
	 *
	 * You can then put different test code in each test to be thorough.
	 */
}
