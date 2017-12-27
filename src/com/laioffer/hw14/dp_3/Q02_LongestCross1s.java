 package com.laioffer.hw14.dp_3;

// 十字架问题
// 四个方向分别重复一下LongestConsecutiveOne的操作 然后取一个最小值
// left -> right
// right -> left
// up -> down
// down -> up
/**
 * 3.Longest Cross Of 1s
 * 
 * Given a matrix that contains only 1s and 0s, find the largest cross which
 * contains only 1s, with the same arm lengths and the four arms joining at the
 * central point.
 * 
 * Return the arm length of the largest cross.
 * 
 * Assumptions
 * 
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0. Examples
 * 
 * { {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1} }
 * 
 * the largest cross of 1s has arm length 2.
 */
public class Q02_LongestCross1s {
	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] left = getDataFromLeft(matrix, matrix.length, matrix[0].length);
		int[][] up = getDataFromUp(matrix, matrix.length, matrix[0].length);
		int[][] right = getDataFromRight(matrix, matrix.length, matrix[0].length);
		int[][] bottom = getDataFromBottom(matrix, matrix.length, matrix[0].length);

		int[][] combined = new int[matrix.length][matrix[0].length];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				combined[i][j] = Math.min(Math.min(left[i][j], up[i][j]), Math.min(right[i][j], bottom[i][j]));
				res = Math.max(res, combined[i][j]);
			}
		}
		return res;
	}

	private int[][] getDataFromLeft(int[][] matrix, int row, int col) {
		int[][] left = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 && j == 0) {
						left[i][j] = 1;
					} else if (i == 0) {
						left[i][j] = left[i][j - 1] + 1;
					} else if (j == 0) {
						left[i][j] = 1;
					} else {
						left[i][j] = left[i][j - 1] + 1;
					}
				}
			}
		}
		return left;
	}

	private int[][] getDataFromUp(int[][] matrix, int row, int col) {
		int[][] up = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 && j == 0) {
						up[i][j] = 1;
					} else if (i == 0) {
						up[i][j] = 1;
					} else if (j == 0) {
						up[i][j] = up[i - 1][j] + 1;
					} else {
						up[i][j] = up[i - 1][j] + 1;
					}
				}
			}
		}
		return up;
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
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		Q02_LongestCross1s lc = new Q02_LongestCross1s();
		System.out.println(lc.largest(matrix));
	}
}
