package com.laioffer.strengthen_4;

import java.util.*;

/**
 * Find all pairs of elements in a given array that sum to the given target
 * number. Return all the pairs of indices. Assumptions The given array is not
 * null and has length of at least 2. Examples A = {1, 3, 2, 4}, target = 5,
 * return [[0, 3], [1, 2]] A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */
public class Q09_TwoSumAllPairs_1 {

	public List<List<Integer>> allPairs(int[] array, int target) {
		// Write your solution here.
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			List<Integer> indexes = map.get(target - array[i]);
			if (indexes != null) {
				for (int index : indexes) {
					result.add(Arrays.asList(index, i));
				}
			}

			if (!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			map.get(array[i]).add(i);

		}
		return result;
	}

}
