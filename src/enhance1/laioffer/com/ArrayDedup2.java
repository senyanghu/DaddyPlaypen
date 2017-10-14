package enhance1.laioffer.com;

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
public class ArrayDedup2 {
	public int[] dedup(int[] array) {
		if (array == null || array.length <= 2) {
			return array;
		}
		int slowIndex = 2; // slow index points the available spot
		for (int fastIndex = 2; fastIndex < array.length; fastIndex++) {
			if (array[slowIndex - 2] == array[fastIndex]) {
				continue;
			} else {
				array[slowIndex] = array[fastIndex];
				slowIndex++;
			}
		}
		return Arrays.copyOf(array, slowIndex);
	}
}
