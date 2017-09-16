/*
Java implementation of counting the inversion using merge sort algo
Author: Dezhi Zhao
Date: 09/15/2017
*/
import java.io.*;
import java.util.Arrays;

class countInversions {
	// This method sorts the input array and returns the number of inversions in the array
	public static long countInv(int[] arr) {
		if (arr.length == 1) {
			return 0;
		}
		int[] leftArray = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int[] rightArray = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		return countInv(leftArray) + countInv(rightArray) + countSplitInv(leftArray, rightArray, arr);
	}
	// This method merges two parts and count the inversions in merging
	public static long countSplitInv(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;
		long inv_count = 0;
		// i, j, k is the index of left/right/resultant merged subarrays
		while ((i < left.length) && (j < right.length)) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			}
			else {
				arr[k++] = right[j++];
				// All the other value in left part is inversions
				inv_count += left.length - i;
			}
		}
		// Copy the remaining elements of each subarray
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
		// Copy back the merged array to origin array (already sorted)
		return inv_count;
	}
	// Driver method to test the function
	public static void main(String[] args) throws IOException{
		int[] arr = new int[100000];
		int i = 0;
		FileInputStream fis = new FileInputStream(new File("IntegerArray.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
        while ((line = br.readLine()) != null) {
            arr[i++] = Integer.valueOf(line);
        }
		System.out.println("Number of inversions: " + countInv(arr));
		br.close();
	}
}
