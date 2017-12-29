package com.laioffer.strengthen_1;

import java.util.Arrays;

public class Q05_Move0ToTheEnd1 {
	// left: all elements to the left hand side of left index are non-zeros
	// right: all elements to the right hand side of right index are zeros
	// [left, right]: unexplored array
	public int[] moveZero(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			if (arr[left] != 0) {
				left++;
			} else if (arr[right] == 0) {
				right--;
			} else {
				swap(arr, left++, right--);
			}
		}

		return Arrays.copyOfRange(arr, 0, left);
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) {
		Q05_Move0ToTheEnd1 solu = new Q05_Move0ToTheEnd1();
		int[] arr = { 0, 0, 0, 1, 0, 2, 0, 3 };
		int[] res = solu.moveZero(arr);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
