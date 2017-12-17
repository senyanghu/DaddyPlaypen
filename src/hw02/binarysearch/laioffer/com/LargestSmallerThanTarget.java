package hw02.binarysearch.laioffer.com;

/**
 * In a sorted array, find the maximum number smaller than target (return index)
 */
public class LargestSmallerThanTarget {
	public int findMaximumSmallerThanTarget(int[] input, int target) {
		if (input == null) {
			return -1;
		}
		int left = 0;
		int right = input.length - 1;
		int res = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (input[mid] < target) {
				res = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}
}
