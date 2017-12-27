package com.laioffer.hw14.dp_3;

// Given a matrix where every element is either 0 or 1, 
// find the largest sub-square surrounded by 1
// 相当于空心的
public class Q04_LargestSubsquare {
	public int largest(int[][] matrix) {
		int[][] m1 = this.getDataFromRight(matrix, matrix.length, matrix[0].length);
		int[][] m2 = this.getDataFromBottom(matrix, matrix.length, matrix[0].length);

		int globalMax = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int len = 1; len <= Integer.min(m1[i][j], m2[i][j]); len++) {
					if (m2[i][j + len - 1] >= len && m1[i + len - 1][j] >= len) { // square can be formed
						globalMax = Integer.max(globalMax, len);
					}
				}
			}
		}

		return globalMax;
	}

	private int[][] getDataFromRight(int[][] matrix, int row, int col) {
		int[][] right = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 && j == col - 1) {
						right[i][j] = 1;
					} else if (i == row - 1) {
						right[i][j] = right[i][j + 1] + 1;
					} else if (j == col - 1) {
						right[i][j] = 1;
					} else {
						right[i][j] = right[i][j + 1] + 1;
					}
				}
			}
		}
		return right;
	}

	private int[][] getDataFromBottom(int[][] matrix, int row, int col) {
		int[][] bottom = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 && j == col - 1) {
						bottom[i][j] = 1;
					} else if (i == row - 1) {
						bottom[i][j] = 1;
					} else if (j == col - 1) {
						bottom[i][j] = bottom[i + 1][j] + 1;
					} else {
						bottom[i][j] = bottom[i + 1][j] + 1;
					}
				}
			}
		}
		return bottom;
	}

	public static void main(String args[]) {
		Q04_LargestSubsquare ls = new Q04_LargestSubsquare();
		int[][] matrix = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 0 } };
		System.out.println(ls.largest(matrix));
	}
}
