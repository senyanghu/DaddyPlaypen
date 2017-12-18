package com.laioffer.hw01.sort;

public class MoveZeroSolution {
	public void moveZero(int[] nums) {
		int insertPosition = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, insertPosition++);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
