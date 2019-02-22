import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Scanner;

/*	Time in Nano-Seconds.
 * 							-----------------------------------------------------------------------------
 * 							| Insert 	| Quick 	| Merge Recursive	| Merge Iterative	| Selection |
 *  -----------------------------------------------------------------------------------------------------
 *	| 10 Random	 			| 2,655		| 4,361		| 5,309				| 8,534				| 2,844		|
 *	-----------------------------------------------------------------------------------------------------
 *	| 100 Random			| 93,108	| 53,096	| 47,028			| 48,734			| 92,539	|
 *	-----------------------------------------------------------------------------------------------------
 *	| 1000 Random			| 3,913,575	| 1,068,183	| 443,923			| 476,349			| 2,486,233	|
 *	-----------------------------------------------------------------------------------------------------
 *	| 1000 few unique 		| 2,712,840	| 837,404	| 412,065			| 473,126			| 3,633,871	|
 *	-----------------------------------------------------------------------------------------------------
 *	| 1000 nearly ordered 	| 3,593,480	| 981,902	| 339,247			| 264,723			| 5,159,631	|
 *	-----------------------------------------------------------------------------------------------------
 * 	| 1000 reverse order	| 4,091,827	| 2,276,692	| 362,761			| 461,747			| 6,585,266	|
 * 	-----------------------------------------------------------------------------------------------------
 * 	| 1000 sorted			| 2,454,944	| 1,929,102	| 277,238			| 234,003			| 2,479,975	|
 * 	-----------------------------------------------------------------------------------------------------
 */


/*
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * Answer: 
 * 
 * b. Which algorithm has the biggest difference between the best and worst performance, based
 * on the type of input, for the input of size 1000? Why?
 * Answer: Selection Sort has the biggest difference between the best(1000 sorted) and worst(1000 reverse order) performance. This is 
 * 		   because ...
 * 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 * based on the input size? Please consider only input files with random order for this answer. 
 * Answer: 
 * 
 * d. Did you observe any difference between iterative and recursive implementations of merge
 * sort?
 * Answer: The recursive method mainly had a faster run time when you look across all the different inputs, there were some inputs 
 * 		   (e.g. the sorted input or the nearly ordered input) where the iterative method was faster. As the inputs became more complex,
 * 		   the recursive method returned a faster time than the last after each input, which did not occur in the iterative method.
 * 
 * e. Which algorithm is the fastest for each of the 7 input files? 
 * Answer: 10 Random -- Insertion Sort
 * 		   100 Random -- Merge Sort Recursive
 * 		   1000 Random -- Merge Sort Recursive
 * 		   1000 few unique -- Merge Sort Recursive
 * 		   1000 nearly ordered -- Merge Sort Iterative
 * `	   1000 reverse ordered -- Merge Sort Recursive
 * 		   1000 sorted -- Merge Sort Iterative
 */		   

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] test = new double[] {};
    	assertEquals("[]", Arrays.toString(SortComparison.insertionSort(test)));
    	assertEquals("[]", Arrays.toString(SortComparison.selectionSort(test)));
    	assertEquals("[]", Arrays.toString(SortComparison.quickSort(test)));
    	
    }

    @Test
    public void testQuickSort() {
    	double[] test = new double[] {4, 2, 6, 1, 7, 10};
    	test = SortComparison.quickSort(test);
    	assertEquals("[1.0, 2.0, 4.0, 6.0, 7.0, 10.0]", Arrays.toString(test));
    	double[] negTest = new double[] {-8, -6, -9, -11, -4, -1};
    	assertEquals("[-11.0, -9.0, -8.0, -6.0, -4.0, -1.0]", Arrays.toString(SortComparison.quickSort(negTest)));
    	
    }
    
    @Test
    public void testSelectionSort() {
    	double[] test = new double[] {5, 3, 8, 9 ,2, 4, 12};
    	test = SortComparison.selectionSort(test);
    	assertEquals("[2.0, 3.0, 4.0, 5.0, 8.0, 9.0, 12.0]", Arrays.toString(test));
    	double[] negTest = new double[] {-8, -6, -9, -11, -4, -1};
    	assertEquals("[-11.0, -9.0, -8.0, -6.0, -4.0, -1.0]", Arrays.toString(SortComparison.selectionSort(negTest)));
    	
    }
    
    @Test
    public void testInsertionSort() {
    	double[] test = new double[] {4, 2, 6, 7, 9, 1};
    	test = SortComparison.insertionSort(test);
    	assertEquals("[1.0, 2.0, 4.0, 6.0, 7.0, 9.0]", Arrays.toString(test));
    	double[] negTest = new double[] {-8, -6, -9, -11, -4, -1};
    	assertEquals("[-11.0, -9.0, -8.0, -6.0, -4.0, -1.0]", Arrays.toString(SortComparison.insertionSort(negTest)));
    }
    
    @Test
    public void testMergeSortIterative() {
    	double[] test = new double[] {4, 2, 6, 7, 9, 1};	
    	test = SortComparison.mergeSortIterative(test);
    	assertEquals("[1.0, 2.0, 4.0, 6.0, 7.0, 9.0]", Arrays.toString(test));
    	double[] negTest = new double[] {-8, -6, -9, -11, -4, -1};
    	assertEquals("[-11.0, -9.0, -8.0, -6.0, -4.0, -1.0]", Arrays.toString(SortComparison.mergeSortIterative(negTest)));
    }
    
    @Test
    public void testMergeSortRecursive() {
    	double[] test = new double[] {5, 3, 8, 9 ,2, 4, 12};
    	test = SortComparison.mergeSortRecursive(test);
    	assertEquals("[2.0, 3.0, 4.0, 5.0, 8.0, 9.0, 12.0]", Arrays.toString(test));
    	double[] negTest = new double[] {-8, -6, -9, -11, -4, -1};
    	assertEquals("[-11.0, -9.0, -8.0, -6.0, -4.0, -1.0]", Arrays.toString(SortComparison.mergeSortRecursive(negTest)));
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *  
     *  public static void main(String[] args) throws FileNotFoundException
     *	{
     *	double[] fileTester = new double[1000];
     *	Scanner input = new Scanner(new File("numbersSorted1000.txt"));
     *	for(int i = 0; i < fileTester.length; i++) {
     *		fileTester[i] = input.nextDouble();
     *	}
     *	long average = 0;
     *	for(int j = 1; j <= 3; j++) {
     *		long startTime = System.nanoTime();
     *   	SortComparison.quickSort(fileTester);
     *   	long stopTime = System.nanoTime(); 
     *   	long timeElapsed = stopTime - startTime;
     *   	System.out.println("Time " + j + " in Nanoseconds: " + timeElapsed);
     *   	average += timeElapsed;
     *	}
     *	average = average / 3;
     *	System.out.println("Average: " + average);
     *	input.close();
     *	}
     *
     */
}