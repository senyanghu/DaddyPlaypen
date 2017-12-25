package com.laioffer.hw09.string_2;

/**
 * 
 * Given an array of elements, reorder it as follows: N1 N2 ... N2k -> N1, Nk+1,
 * N2, Nk+2, .... , Nk, N2k N1 N2 ... N2k+1 -> N1, Nk+1, N2, Nk+2, .... , Nk,
 * N2k, N2k+1
 */
// ABCDE12345 -> A1B2C3D4E5
public class Q05_ReorderArray {
	private void reorderHelper(char[] array, int left, int right) {
		int length = right - left + 1;
		if (length <= 2) {
			return;
		}

		int mid = left + length / 2;
		int leftmid = left + length / 4;
		int rightmid = left + length * 3 / 4;

		reverse(array, leftmid, mid - 1);
		reverse(array, mid, rightmid - 1);
		reverse(array, leftmid, rightmid - 1);

		reorderHelper(array, left, left + (leftmid - left) * 2 - 1);
		reorderHelper(array, left + (leftmid - left) * 2, right);
	}

	private void reverse(char[] array, int start, int end) {
		while (start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String args[]) {
		char[] inputArray = { 'A', 'B', 'C', '1', '2', '3' };
		Q05_ReorderArray ra = new Q05_ReorderArray();
		ra.reorderHelper(inputArray, 0, 5);
		System.out.println(inputArray);
	}
}
