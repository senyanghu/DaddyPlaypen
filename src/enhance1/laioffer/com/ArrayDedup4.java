package enhance1.laioffer.com;

import java.util.Arrays;

/**
 * Given an unsorted integer array, remove adjacent duplicate elements
 * repeatedly, from left to right. For each group of elements with the same
 * value do not keep any of them. Do this in-place, using the left side of the
 * original array. Return the array after deduplication. Assumptions
 * 
 * The given array is not null
 * 
 * Examples {1, 2, 3, 3, 3, 2, 2} -> {1, 2, 2, 2} -> {1}, return {1}
 */
public class ArrayDedup4 {
	public int[] dedup(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int resultIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (resultIndex == -1 || array[resultIndex] != array[i]) {
				array[++resultIndex] = array[i];
			} else {
				while (i + 1 < array.length && array[resultIndex] == array[i + 1]) { // 此处太精髓了 i + 1
					i++;
				}
				resultIndex--;
			}
		}
		return Arrays.copyOf(array, resultIndex + 1);
	}
}
