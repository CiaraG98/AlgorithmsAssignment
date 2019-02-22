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
    
    /*							-----------------------------------------------------------------------------
     * 							| Insert 	| Quick 	| Merge Recursive	| Merge Iterative	| Selection |
     *  -----------------------------------------------------------------------------------------------------
     *	| 10 Random	 			| 			|			|					|					|			|
     *	-----------------------------------------------------------------------------------------------------
     *	| 100 Random			|			|			|					|					|			|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 Random			|			|			|					|					|			|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 few unique 		|			|			|					|					|			|
     *	-----------------------------------------------------------------------------------------------------
     *	| 1000 nearly ordered 	|			|			|					|					|			|
     *	-----------------------------------------------------------------------------------------------------
     * 	| 1000 reverse order	|			|			|					|					|			|
     * 	-----------------------------------------------------------------------------------------------------
     * 	| 1000 sorted			|			|			|					|					|			|
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
