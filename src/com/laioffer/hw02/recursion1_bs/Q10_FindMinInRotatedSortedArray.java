package com.laioffer.hw02.recursion1_bs;

/**
 * no dup and dup both can handle
 * 
 * for example: 4, 5, 6, 7, 0, 1, 2
 */
public class Q10_FindMinInRotatedSortedArray {
	public int findMin(int[] input) {
		if (input == null || input.length == 0) {
			return -1;
		}
		int start = 0;
		int end = input.length - 1;
		int target = input[input.length - 1];

		// find the first element <= target
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (input[mid] == target) {
				end = mid;
			} else if (input[mid] < target) {
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

	public static void main(String args[]) {
		Q10_FindMinInRotatedSortedArray sol = new Q10_FindMinInRotatedSortedArray();
		int[] array = { 3, 3, 4, 4, 5, 6, 7, 0, 0, 1, 1, 2, 2 };
		System.out.println(sol.findMin(array));
	}
}
