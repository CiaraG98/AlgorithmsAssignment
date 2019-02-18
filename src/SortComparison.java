import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
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

    }//end insertionsort

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
    	return a; //if they low and high have crossed, the array is sorted 
    	
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
    	return null;

		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	return null;
    	

    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    
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
    		for(int j = i+1; j < a.length; j++) {
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

  
    public static void main(String[] args) {
    	
    	double[] test = new double[] {4, 2, 6, 1, 7, 10};
    	System.out.println("Before sort: " + Arrays.toString(test));
    	System.out.println(" ");
    	System.out.println("After sort: " + Arrays.toString(quickSort(test)));

    }

 }
