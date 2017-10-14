package hw08.laioffer.com;

import java.util.*;

// Binary Search
// Run binary search for each element X in a[N]

// HashSet
public class CommonNumsTwoSortedArray {
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
