package com.laioffer.hw02.recursion1_bs;

// binary search 两大诀窍
// (1) 每一次要把问题的scope narrow down
// (2) 在每一轮的迭代不能把potential result给放过去
public class Q06_FirstOccurrence {

	public int firstOccurTemplate(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				right = mid; // right = mid - 1, wrong, this may pass correct result
			} else if (array[mid] < target) {
				left = mid; // left = mid + 1, this is also correct
			} else { // array[mid] > target
				right = mid; // right = mid - 1, this is also correct
			}
		}
		if (array[left] == target) {
			return left;
		}
		if (array[right] == target) {
			return right;
		}
		return -1;
	}

	public int firstOccur(int[] array, int target) {
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
				end = mid - 1;
			} else if (array[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		Q06_FirstOccurrence fos = new Q06_FirstOccurrence();
		int[] input = { 1, 2, 2, 2, 3 };
		System.out.println(fos.firstOccur(input, 2));
		System.out.println(fos.firstOccurTemplate(input, 2));
	}
}
