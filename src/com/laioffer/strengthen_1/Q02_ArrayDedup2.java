package com.laioffer.strengthen_1;

import java.util.Arrays;

/**
 * 
 * Given a sorted integer array, remove duplicate elements. For each group of
 * elements with the same value keep at most two of them. Do this in-place,
 * using the left side of the original array and maintain the relative order of
 * the elements of the array. Return the array after deduplication. Assumptions
 * 
 * The given array is not null
 * 
 * Examples {1, 2, 2, 3, 3, 3} -> {1, 2, 2, 3, 3}
 */
public class Q02_ArrayDedup2 {
	public int[] dedup_excluding(int[] array) {
		if (array == null || array.length <= 2) {
			return array;
		}
		// slow: all elements to the left hand side of slow (excluding slow) are the
		// results, slow index points the available spot
		// fast: current index
		int slow = 2;
		for (int fast = 2; fast < array.length; fast++) {
			if (array[slow - 2] == array[fast]) {
				continue;
			} else {
				array[slow++] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow);
	}
}
