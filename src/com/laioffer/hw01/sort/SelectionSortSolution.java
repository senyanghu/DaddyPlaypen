package com.laioffer.hw01.sort;

public class SelectionSortSolution {

	private static int[] sort(int[] array) {
		// sanity check first
		if (array == null || array.length == 0) {
			return array;
		}
		int min, temp;
		for (int i = 0; i < array.length - 1; i++) { // outer loop: how many iterations
			min = i;
			for (int j = i + 1; j < array.length; j++) { // inner loop: find the global min from the rest of the elements
				if (array[j] < array[min]) {
					min = j;
				}
			}

			if (min == i) {
				continue;
			}

			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		SelectionSortSolution s = new SelectionSortSolution();
		int[] array = { 3, 2, 1, -4 };
		//int[] result = s.sort(array);
		int[] result = s.sort_version2(array);
		for (int i : result) {
			System.out.println(i);
		}
	}


	private static int[] sort_version2(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return arr;
		}

		// how many iterations
		for (int i = 0; i < arr.length - 1; i++) {
			int globalMinIndex = i;
			// find the global min in the rest of array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[globalMinIndex]) {
					globalMinIndex = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[globalMinIndex];
			arr[globalMinIndex] = temp;
		}

		return arr;
	}

}