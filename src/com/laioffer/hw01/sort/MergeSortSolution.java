package com.laioffer.hw01.sort;

import java.util.Arrays;

// a[n] = 1, 3, 5, 7, 9, 8, 6, 4, 2, 0
// 1st: 1 3 5 7 9
// 2nd: 0 2 4 6 8
// combine them: 谁小移谁
// time complexity: O(nlogn)
// space complexity: O(n)
public class MergeSortSolution {
	public int[] mergeSort(int[] array) {

		if (array == null || array.length == 0) {
			return array;
		}

		if (array.length == 1) {
			return array;
		}

		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		left = mergeSort(left);

		int[] right = Arrays.copyOfRange(array, mid, array.length);
		right = mergeSort(right);

		array = combine(left, right);

		return array;
	}

	public int[] combine(int[] left, int[] right) {
		int leftIndex = 0;
		int rightIndex = 0;
		int[] combined = new int[left.length + right.length];
		int index = 0;

		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				combined[index++] = left[leftIndex++];
			} else {
				combined[index++] = right[rightIndex++];
			}
		}

		if (leftIndex == left.length) {
			while (rightIndex < right.length) {
				combined[index++] = right[rightIndex++];
			}
		} else {
			while (leftIndex < left.length) {
				combined[index++] = left[leftIndex++];
			}
		}

		return combined;
	}

	public static void main(String args[]) {
		MergeSortSolution mss = new MergeSortSolution();
		int[] array = { 3, -1 };
		int[] result = mss.mergeSort(array);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
