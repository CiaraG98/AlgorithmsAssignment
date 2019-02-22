import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Scanner;
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
    	
    }
    
    @Test
    public void testSelectionSort() {
    	double[] test = new double[] {5, 3, 8, 9 ,2, 4, 12};
    	test = SortComparison.selectionSort(test);
    	assertEquals("[2.0, 3.0, 4.0, 5.0, 8.0, 9.0, 12.0]", Arrays.toString(test));
    	
    }
    
    @Test
    public void testInsertionSort() {
    	double[] test = new double[] {4, 2, 6, 7, 9, 1};
    	test = SortComparison.insertionSort(test);
    	assertEquals("[1.0, 2.0, 4.0, 6.0, 7.0, 9.0]", Arrays.toString(test));
    }
    
    @Test
    public void testMergeSortIterative() {
    	double[] test = new double[] {4, 2, 6, 7, 9, 1};	
    	test = SortComparison.mergeSortIterative(test);
    	assertEquals("[1.0, 2.0, 4.0, 6.0, 7.0, 9.0]", Arrays.toString(test));
    }
    
    @Test
    public void testMergeSortRecursive() {
    	double[] test = new double[] {5, 3, 8, 9 ,2, 4, 12};
    	test = SortComparison.mergeSortRecursive(test);
    	assertEquals("[2.0, 3.0, 4.0, 5.0, 8.0, 9.0, 12.0]", Arrays.toString(test));
    }
    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    
    /*	Time in Nano-Seconds.
     * 							-----------------------------------------------------------------------------
     * 							| Insert 	| Quick 	| Merge Recursive	| Merge Iterative	| Selection |
     *  -----------------------------------------------------------------------------------------------------
     *	| 10 Random	 			| 4,171		| 6,826		| 9,102				|					| 4,930		|
     *	-----------------------------------------------------------------------------------------------------
     *	| 100 Random			| 131,603	| 82,110	| 62,388			|					| 220,539	|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 Random			| 4,068,122	| 1,276,017	| 1,194,287			|					| 5,355,329	|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 few unique 		| 4,760,081	| 1,565,961	| 544,805			|					| 4,538,594	|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 nearly ordered 	| 4,760,650	| 6,403,032	| 1,458,251			|					| 5,159,631	|
     *	-----------------------------------------------------------------------------------------------------
     * 	| 1000 reverse order	| 10,589,84	| 7,174,255	| 1,986,938			|					| 12,078,645|
     * 	-----------------------------------------------------------------------------------------------------
     * 	| 1000 sorted			| 5,873,397	| 8,006,160	| 1,043,531			|					| 8,841,479	|
     * 	-----------------------------------------------------------------------------------------------------
     */
    
    
    /*
     * a. Which of the sorting algorithms does the order of input have an impact on? Why?
     * 
     * b. Which algorithm has the biggest difference between the best and worst performance, based
     * on the type of input, for the input of size 1000? Why?
     * 
     * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
     * based on the input size? Please consider only input files with random order for this answer. 
     * 
     * d. Did you observe any difference between iterative and recursive implementations of merge
     * sort?
     * 
     * e. Which algorithm is the fastest for each of the 7 input files? 
     */

}
