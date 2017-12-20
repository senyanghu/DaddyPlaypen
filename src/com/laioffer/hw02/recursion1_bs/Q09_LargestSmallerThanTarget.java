package com.laioffer.hw02.recursion1_bs;

/**
 * In a sorted array, find the maximum number smaller than target (return index)
 */
public class Q09_LargestSmallerThanTarget {
	public int findLargestSmallerThanTarget(int[] input, int target) {
		if (input == null || input.length == 0) {
			return -1;
		}

		int left = 0;
		int right = input.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (input[mid] == target) {
				right = mid;
			} else if (input[mid] < target) {
				left = mid;
			} else { // input[mid] > target
				right = mid;
			}
		}

		if (input[right] < target) {
			return right;
		} else if (input[left] < target) {
			return left;
		} else {
			return -1;
		}
	}
}
