package com.laioffer.hw02.recursion1_bs;

// O(log(m*n))
public class Q04_BinarySearchMatrix {
	public int[] searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			// convert 1d coordinates to 2d coordinates
			int midX = mid / n;
			int midY = mid % n;

			if (matrix[midX][midY] == target) {
				return new int[] { midX, midY };
			} else if (matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
