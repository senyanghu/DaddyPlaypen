package com.laioffer.hw02.recursion1_bs;

// (1) for each round, we try to reduce our search space by 1/2
// (at lest we need to reduce it each round)
// (2) we must guarantee that the target (if exist) cannot be purged out of the remaining scope
public class Q03_BinarySearchClassic {
	/**
	 * 
	 * @param array
	 *            this is sorted
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] array, int target) {
		// sanity check
		if (array == null || array.length == 0) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}
