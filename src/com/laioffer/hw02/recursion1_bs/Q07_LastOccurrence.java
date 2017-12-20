package com.laioffer.hw02.recursion1_bs;

public class Q07_LastOccurrence {
	public int lastOccurTemplate(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				left = mid; // do not stop here, keep checking to the right
			} else if (array[mid] < target) {
				left = mid; // left = mid + 1, this is also correct
			} else { // array[mid] > target
				right = mid; // right = mid - 1, this is also correct
			}
		}
		if (array[right] == target) {
			return right;
		}
		if (array[left] == target) {
			return left;
		}
		return -1;
	}

	public int lastOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;
		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				res = mid;
				start = mid + 1;
			} else if (array[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return res;
	}

	public static void main(String args[]) {
		Q07_LastOccurrence los = new Q07_LastOccurrence();
		int[] input = { 1, 2, 2, 2, 2, 2, 2, 3 };

		System.out.println(los.lastOccur(input, 3));
		System.out.println(los.lastOccurTemplate(input, 3));
	}
}
