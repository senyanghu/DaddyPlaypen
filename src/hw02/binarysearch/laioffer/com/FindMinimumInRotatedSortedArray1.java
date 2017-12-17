package hw02.binarysearch.laioffer.com;

/**
 * no dup
 */
public class FindMinimumInRotatedSortedArray1 {
	public int min(int[] input) {
		if (input == null || input.length == 0) {
			return -1;
		}
		int start = 0;
		int end = input.length - 1;
		int target = input[input.length - 1];

		// find the first element <= target
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (input[mid] <= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (input[start] <= target) {
			return input[start];
		} else {
			return input[end];
		}
	}
}
