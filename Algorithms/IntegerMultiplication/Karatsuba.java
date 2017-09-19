/*
Karatsuba's Algorithm for 2 n-bit numbers multiplicaiton
Author: Dezhi Zhao
Date: 09/18/2017
*/

public class Karatsuba {
	/*
	* Returns product of num1 and num2
	* Gives running time of O(n^1.59) as opposed
	* to O(n^2) of "grade school" multiplicaiton
	*/

	// find the maximum length of 2 number
	public static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	/* convert the number into string and split it with the index m
	* For example: Given 12345 as the number and index m = 2
	* it can be written as 123 * 10^2 and 45 
	*/
	public static String[] strCopy(long index, String string) {
		String first = "", second = "";
		long actualIndex = string.length() - index;
		for (int i = 0; i < (int)actualIndex; i++) {
			first += string.charAt(i);
		}
		for (int i = (int)actualIndex; i < string.length(); i++) {
			second += string.charAt(i);
		}
		return new String[] {first, second};
	}

	// an exponent function
	public static long power(long x, long y) {
		if (y == 0) {
			return 1;
		} else {
			long result = 1;
			for (int i = 1; i <= y; i++) {
				result *= x;
			}
			return result;
		}
	}

	/*
	* Take two numbers, x and y
	* Example: 12345 and 6789
	* Find a base b and power m to separate it into 2 parts
	* We'll pick b = 10, and m to be half the maximum length of the 2 numbers
	* The form is that:
	* x = x1 * b^m + x0
	* y = y1 * b^m + y0
	* -------------
	* Using the above example
	* x1 = 123 
	* x0 = 45
	* -------------
	* y1 = 67
	* y0 = 89
	* -------------
	* b = 10 and m = 2
	* -------------
	* 
	* The recursive algorithm is as follows:
	* 
	* if x < 10 or y < 10, return x * y (single digit multiplication)
	* otherwise:
	* Let z2 = multiplication(x1, y1)
	* Let z0 = multiplication(x0, y0)
	* Let z1 = multiplication(x1+y0, x0+y1) - z0 - z2
	* And the result is as following:
	* z2 * b^2m + z1 * b^m + z0
	*/
	public static long multiplicaiton(long x, long y) {
		// single digit multiplication
		if (x < 10 || y < 10) {
			return x * y;
		}
		else {
			// Convert number to strings
			String xString = Integer.toString((int)x);
			String yString = Integer.toString((int)y);

			// Local variables
			long m = max(xString.length(), yString.length());
			long m2 = m/2;
			long high1 = Integer.parseInt(strCopy(m2, xString)[0]);
			long low1 = Integer.parseInt(strCopy(m2, xString)[1]);
			long high2 = Integer.parseInt(strCopy(m2, yString)[0]);
			long low2 = Integer.parseInt(strCopy(m2, yString)[1]);

			// Recursive calls
			long z0 = multiplicaiton(low1, low2);
			long z2 = multiplicaiton(high1, high2);
			long z1 = multiplicaiton((low1 + high1), (low2 + high2)) - z0 - z2;

			return (z2 * power(10, 2*m2) + (z1 * power(10, m2)) + z0);
		}
	}

	public static void main(String[] args) {
		System.out.println(multiplicaiton(3489092, 8637392));
	}
}
