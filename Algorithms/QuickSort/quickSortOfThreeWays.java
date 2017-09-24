/*
* Implementation of QuickSort (2)
* Calculate the number of comparisons of different choice of pivot
* Author: Dezhi Zhao
* Date: 09/21/2017
*/
import java.io.*;
import java.util.*;

class quickSortOfThreeWays {
	static long count;
	// Read the input file and store its elements into input array
	static void readInputToArray(int[] input) {
		BufferedReader br = null;
		int i = 0;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader("QuickSort.txt"));
			while((currentLine = br.readLine()) != null) {
				input[i++] = Integer.parseInt(currentLine);
			}
		} catch(IOException e) {
			System.out.println("Exception => " + e);
		}
	}

	// Partition the array around the pivot and return the rightful position of pivot
	static int partition(int[] array, int startIndex, int endIndex, int pivot) {
		int i = startIndex + 1;
		for(int j = startIndex + 1; j <= endIndex; j++) {
			if(array[j] < pivot) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, startIndex, i - 1);
		return i - 1;
	}

	// Choose the first element as pivot and Sort the array and return the comparisions
	static long sortUsingFirstAsPivot(int[] array, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
			count += endIndex - startIndex;
			int pivot = array[startIndex];
			int pivotIndex = partition(array, startIndex, endIndex, pivot);
			sortUsingFirstAsPivot(array, startIndex, pivotIndex - 1);
			sortUsingFirstAsPivot(array, pivotIndex + 1, endIndex);
		}
		return count;
	}

	// Choose the last element as pivot and Sort the array and return the comparisions
	static long sortUsingLastAsPivot(int[] array, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
			count += endIndex - startIndex;
			int pivot = array[endIndex];
			swap(array, startIndex, endIndex);
			int pivotIndex = partition(array, startIndex, endIndex, pivot);
			sortUsingLastAsPivot(array, startIndex, pivotIndex - 1);
			sortUsingLastAsPivot(array, pivotIndex + 1, endIndex);
		}
		return count;
	}

	// Choose the last element as pivot and Sort the array and return the comparisions
	static long sortUsingMedianAsPivot(int[] array, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
			count += endIndex - startIndex;
			int pivot = 0;
			int mid = startIndex + (endIndex - startIndex) / 2;
			if(array[startIndex] > array[mid] && array[startIndex] > array[endIndex]) {
				if(array[mid] > array[endIndex]) {
					pivot = array[mid];
					swap(array, startIndex, mid);
				}
				else {
					pivot = array[endIndex];
					swap(array, startIndex, endIndex);
				}
			}
			if(array[endIndex] > array[mid] && array[endIndex] > array[startIndex]) {
				if(array[mid] > array[startIndex]) {
					pivot = array[mid];
					swap(array, startIndex, mid);
				}
				else {
					pivot = array[startIndex];
				}
			}
			if(array[mid] > array[startIndex] && array[mid] > array[endIndex]) {
				if(array[startIndex] > array[endIndex]) {
					pivot = array[startIndex];
				}
				else {
					pivot = array[endIndex];
					swap(array, startIndex, endIndex);
				}
			}
			int pivotIndex = partition(array, startIndex, endIndex, pivot);
			sortUsingMedianAsPivot(array, startIndex, pivotIndex - 1);
			sortUsingMedianAsPivot(array, pivotIndex + 1, endIndex);
		}
		return count;
	}

	// Swap two elements in the array
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	// Driver of the program
	public static void main(String[] args) {
		long result = 0;
		int[] input = new int[10000];
		readInputToArray(input);
		result = sortUsingFirstAsPivot(input, 0, input.length - 1);
		System.out.print("Using firt element as pivot: ");
		System.out.println("Number of comparisons => " + result);

		input = new int[10000];
		readInputToArray(input);
		count = 0;
		result = sortUsingLastAsPivot(input, 0, input.length - 1);
		System.out.print("Using last element as pivot: ");
		System.out.println("Number of comparisons => " + result);

		input = new int[10000];
		readInputToArray(input);
		count = 0;
		result = sortUsingMedianAsPivot(input, 0, input.length - 1);
		System.out.print("Using median-of-three as pivot: ");
		System.out.println("Number of comparisons => " + result);
	}
}
