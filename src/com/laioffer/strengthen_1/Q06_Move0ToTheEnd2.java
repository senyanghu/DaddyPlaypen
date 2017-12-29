package com.laioffer.strengthen_1;

/**
 * 
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array need to be
 * maintained. Assumptions:
 * 
 * The given array is not null.
 * 
 * Examples:
 * 
 * {1} --> {1}
 * 
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */
public class Q06_Move0ToTheEnd2 {
	public int[] moveZero(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		// slow: all elements to the left hand side of slow (Excluding the slow) must be
		// non-zeros
		// fast: current index
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (arr[fast] != 0) {
				arr[slow++] = arr[fast];
			}
		}
		while (slow < arr.length) {
			arr[slow++] = 0;
		}
		return arr;
	}
}
