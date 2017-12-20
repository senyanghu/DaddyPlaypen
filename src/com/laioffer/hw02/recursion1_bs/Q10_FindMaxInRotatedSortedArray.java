package com.laioffer.hw02.recursion1_bs;

// 这条题目和find peak几乎一样 参考的九章算法的答案
public class Q10_FindMaxInRotatedSortedArray {
	public int findMax(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 1;
		int right = array.length - 2;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] > array[mid + 1]) {
				right = mid;
			} else { // array[mid] <= array[mid + 1]
				left = mid;
			}
		}

		if (array[left] > array[right]) {
			return array[left];
		} else {
			return array[right];
		}
	}

	public static void main(String args[]) {
		Q10_FindMaxInRotatedSortedArray sol = new Q10_FindMaxInRotatedSortedArray();
		int[] array = { 1, 4, 5, 100, 99, 98, 2 };
		System.out.println(sol.findMax(array));
	}
}
