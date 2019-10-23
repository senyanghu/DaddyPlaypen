package com.laioffer.hw01.sort;

public class MoveZeroSolution {
	public void moveZeroToRight(int[] numbers) {
		int insertPosition = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0) {
				swap(numbers, i, insertPosition++);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
