package com.laioffer.hw02.recursion1_bs;

public class Q09_SmallestLargerThanTarget {
	public int findSmallestLargerThanTarget(int[] input, int target) {
		if (input == null || input.length == 0) {
			return -1;
		}
		int left = 0;
		int right = input.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (input[mid] == target) {
				left = mid;
			} else if (input[mid] > target) {
				right = mid;
			} else { // input[mid] < target
				left = mid;
			}
		}

		if (input[left] > target) {
			return left;
		} else if (input[right] > target) {
			return right;
		} else {
			return -1;
		}
	}
}
