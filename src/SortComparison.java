import java.util.Arrays;
// -------------------------------------------------------------------------
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Ciara Gilsenan, 17324130
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     */
    static double [] insertionSort (double a[]){
    	for(int i = 1; i < a.length; i++) {
    		for(int j = i; j > 0; j--) {
    			if(a[j] < a[j - 1]) {
        			double tmp = a[j];
        			a[j] = a[j - 1];
        			a[j - 1] = tmp;
        		}
    		}
    	}
    	return a;
    }
    
    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	return quickSort(a, 0, a.length - 1);
    }
    
    private static double[] quickSort(double a[], int low, int high) {
    	if(low < high) {
    		double pivot = a[low];
    		int index = partition(a, low, high, pivot); //retrieves partition index
    		quickSort(a, low, index - 1); //sorts one partition
    		quickSort(a, index, high); //sorts another partition
    	}
    	return a; //if the low and high have crossed (low > high), the array/sub-array is sorted 
    }
    
    private static int partition(double a[], int low, int high, double pivot) {
    	while(low <= high) {
    		while(a[low] < pivot) { //finds element smaller larger than pivot
    			low++;
    		}
    		while(a[high] > pivot) { //finds element smaller than pivot
    			high--;
    		}
    		if(low <= high) { //swaps them 
    			double tmp = a[low];
    			a[low] = a[high];
    			a[high] = tmp;
    			
    			low++;
    			high--;
    		}
    	}
    	return low; //returns the partition point (pivot)
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	int N = a.length;
    	double[] aux = new double[N];
    	for(int i = 1; i < N; i = i + i) {
    		for(int low = 0; low < N - i; low += i + i) {
    			merge(a, aux, low, low + i - 1, Math.min(low + i + i-1, N - 1));
    		}
    	}
    	return a;
    }
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
 
    	double[] aux = new double[a.length];
    	return mergeSortRecursive(a, aux, 0, a.length - 1);
	
   }
    
   private static double[] mergeSortRecursive(double a[], double aux[], int low, int high) {
	   if(high <= low) {
		   return a;
	   }
	   int mid = (low + high) / 2;
	   mergeSortRecursive(a, aux, low, mid);
	   mergeSortRecursive(a, aux, mid + 1, high);
	   return merge(a, aux, low, mid, high);
   }
   
   private static double[] merge(double a[], double aux[], int low, int mid, int high) {
	   for(int i = low; i <= high; i++) {
		   aux[i] = a[i];
	   }
	   
	   int i = low;
	   int j = mid + 1;
	   for(int p = low; p <= high; p++) {
		   if(i > mid)
			   a[p] = aux[j++];
		   else if(j > high)
			   a[p] = aux[i++];
		   else if(aux[j] < aux[i])
			   a[p] = aux[j++];
		   else
			   a[p] = aux[i++];
	   }
	   return a;
   }
    	
   
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	for(int i = 0; i < a.length; i++) {
    		int min = i;
    		for(int j = i + 1; j < a.length; j++) {
    			if(a[j] < a[min])
    				min = j;
    		}
    		//Does Swap
    		double temp = a[min];
    		a[min] = a[i];
    		a[i] = temp;
    	}
    	
    	return a;
    }

  
    /*public static void main(String[] args) {
    	
    	double[] test = new double[] {4, 2, 6, 1, 7, 10};
    	System.out.println("Before sort: " + Arrays.toString(test));
    	System.out.println(" ");
    	System.out.println("After sort: " + Arrays.toString(mergeSortIterative(test)));
    }*/
    public static void main(String[] args) throws FileNotFoundException
    	{
    	double[] fileTester = new double[1000];
    	Scanner input = new Scanner(new File("numbers1000.txt"));
    	for(int i = 0; i < fileTester.length; i++) {
    		fileTester[i] = input.nextDouble();
    	}
    	long average = 0;
    	for(int j = 1; j <= 3; j++) {
    		long startTime = System.nanoTime();
       	SortComparison.mergeSortRecursive(fileTester);
       	long stopTime = System.nanoTime(); 
       	long timeElapsed = stopTime - startTime;
       	System.out.println("Time " + j + " in Nanoseconds: " + timeElapsed);
       	average += timeElapsed;
    	}
    	average = average / 3;
    	System.out.println("Average: " + average);
    	double milliseconds = average / 1000000.0;
    	System.out.println("Converted: " + milliseconds);
    	input.close();
    	}
    
 }
