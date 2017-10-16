package hw02.binarysearch.laioffer.com;

public class ClosestInSortedArraySolution {
	public int closest(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
			return start;
		} else {
			return end;
		}
	}
}
