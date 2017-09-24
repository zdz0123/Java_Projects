/*
* Implementation of QuickSort
* Calculate the number of comparisons of different choice of pivot
* Author: Dezhi Zhao
* Date: 09/19/2017
*/

import java.io.*;
public class quickSort {
	public long count = 0;
	/*
	* Partition the array around the pivot and return the position of pivot
	* Choose the pivot in three ways - first / last / median-of-three
	*/
	private int partition(int[] array, int left, int right, int pivot) {
		/*
		* ------------------
		* No matter choose which element as the pivot
		* Just swap with the first element and then do the partition
		* ------------------
		*/
		int i = left + 1;
		for (int j = left + 1; j <= right; j++) {
			if (array[j] < pivot) {
				// Swap the A[j] and A[i]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
		}
		// Swap the pivot to its rightful position
		int temp = array[left];
		array[left] = array[i - 1];
		array[i - 1] = temp;
		return i - 1;
	}

	/*
	* The main function to implement quickSort
	* And also find the total number of comparisons 
	*/
	private long sort(int[] array, int left, int right) {
		// Base case presents that sorting has been finished
		if (left < right) {
			// Each recursive call will do the comparisons equal to the length of subArray
			count += right - left;
			/*
			* ------------------
			* 1. Choose the first element as pivot
			* ------------------
			*/
			// int pivot = array[left];

			/*
			* ------------------
			* 2. Choose the last element as pivot
			* ------------------
			*/
			// int pivot = array[right];
			// swap(array, left, right);

			/*
			* ------------------
			* 3. Choose the median-of-three as pivot
			* ------------------
			*/
			int pivot = 0;
			int mid = left + (right - left) / 2;
			if (array[left] > array[right] && array[left] > array[mid]) {
				if (array[right] > array[mid]) {
					pivot = array[right];
					swap(array, left, right);
				}
				else {
					pivot = array[mid];
					swap(array, left, mid);
				}
			}
			if (array[right] > array[left] && array[right] > array[mid]) {
				if (array[left] > array[mid]) {
					pivot = array[left];
				}
				else {
					pivot = array[mid];
					swap(array, left, mid);
				}
			}
			if (array[mid] > array[right] && array[mid] > array[left]) {
				if (array[right] > array[left]) {
					pivot = array[right];
					swap(array, left, right);
				}
				else {
					pivot = array[left];
				}
			}

			// Partition array around pivot and return the rightful position of the pivot
			int pivotIndex = partition(array, left, right, pivot);

			// Recursively sort the 1st and 2nd subarray until all the elements are sorted
			sort(array, left, pivotIndex - 1);
			sort(array, pivotIndex + 1, right);
		}
		return count;
	}

	/*
	* Swap two elements in the array
	*/
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/*
	* A utility function to print array of size n
	* To verify that QuickSort function is correct
	*/
	private void printArray(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}


	// Driver program
	public static void main(String[] args) {
		int n = 10000;
		int[] arr = new int[n];
		int i = 0;
		BufferedReader br = null;
		try {
		  	String sCurrentLine = null;
		  	br = new BufferedReader(new FileReader("QuickSort.txt"));
		  	while ((sCurrentLine = br.readLine()) != null) {
		  	  	arr[i++] = Integer.parseInt(sCurrentLine);
			}
		} catch (IOException e) {
		  	System.out.println("exception => " + e);
		}
		quickSort ob = new quickSort();
		System.out.println("Number of comparisons: " + ob.sort(arr, 0, n - 1));
	}
}

