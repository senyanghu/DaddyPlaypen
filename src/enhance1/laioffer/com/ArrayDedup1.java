package enhance1.laioffer.com;

import java.util.Arrays;

/**
 * 
 * Given a sorted integer array, remove duplicate elements. For each group of
 * elements with the same value keep only one of them. Do this in-place, using
 * the left side of the original array and maintain the relative order of the
 * elements of the array. Return the array after deduplication. Assumptions
 * 
 * The array is not null
 * 
 * Examples
 * 
 * {1, 2, 2, 3, 3, 3} -> {1, 2, 3}
 */
public class ArrayDedup1 {
	public int[] dedup(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int slowIndex = 1; // slow index points the available spot
		for (int fastIndex = 1; fastIndex < array.length; fastIndex++) {
			if (array[slowIndex - 1] == array[fastIndex]) {
				continue;
			} else {
				array[slowIndex++] = array[fastIndex];
			}
		}
		return Arrays.copyOf(array, slowIndex);
	}
}
