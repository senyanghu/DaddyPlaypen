package com.laioffer.hw01.sort;

public class SelectionSortSolution {

	private static int[] sort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}
		int min, temp;
		for (int i = 0; i < array.length - 1; i++) { // outer loop: how many iterations
			min = i;
			for (int j = i + 1; j < array.length; j++) { // inner loop: find the global from the rest of the elements
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
		// SelectionSort s = new SelectionSort();
		int[] array = { 3, 2, 1, -4 };
		int[] result = SelectionSortSolution.sort(array);
		for (int i : result) {
			System.out.println(i);
		}
	}

}