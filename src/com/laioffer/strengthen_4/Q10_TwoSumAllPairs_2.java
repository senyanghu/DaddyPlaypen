package com.laioffer.strengthen_4;

import java.util.*;

/**
 * Find all pairs of elements in a given array that sum to the pair the given
 * target number. Return all the distinct pairs of values. Assumptions The given
 * array is not null and has length of at least 2 The order of the values in the
 * pair does not matter Examples A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6,
 * return [[2, 4], [3, 3]]
 */
public class Q10_TwoSumAllPairs_2 {

	public List<List<Integer>> allPairs(int[] array, int target) {
		// Write your solution here.
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer count = map.get(array[i]);
			if (array[i] * 2 == target && count != null && count == 1) {
				result.add(Arrays.asList(array[i], array[i]));
			} else if (count == null && map.containsKey(target - array[i])) {
				result.add(Arrays.asList(array[i], target - array[i]));
			}

			if (count == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], count + 1);
			}
		}
		return result;
	}

}
