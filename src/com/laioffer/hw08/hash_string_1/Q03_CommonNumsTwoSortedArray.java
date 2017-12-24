package com.laioffer.hw08.hash_string_1;

import java.util.*;

// Binary Search
// Run binary search for each element X in a[N]

// HashSet
public class Q03_CommonNumsTwoSortedArray {
	public List<Integer> common(List<Integer> listA, List<Integer> listB) {
		List<Integer> res = new ArrayList<>();
		int indexA = 0;
		int indexB = 0;

		while (indexA < listA.size() && indexB < listB.size()) {
			if (listA.get(indexA) == listB.get(indexB)) {
				res.add(listA.get(indexA));
				indexA++;
				indexB++;
			} else if (listA.get(indexA) < listB.get(indexB)) {
				indexA++;
			} else {
				indexB++;
			}
		}
		return res;
	}
}
