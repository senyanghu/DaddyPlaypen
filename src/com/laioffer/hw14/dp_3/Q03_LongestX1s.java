package com.laioffer.hw14.dp_3;

/**
 * 1010 0101 1010 0100
 */
public class Q03_LongestX1s {
	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] leftUp = getDataFromLeftUp(matrix, matrix.length, matrix[0].length);
		int[][] rightUp = getDataFromRightUp(matrix, matrix.length, matrix[0].length);
		int[][] rightBottom = getDataFromRightBottom(matrix, matrix.length, matrix[0].length);
		int[][] leftbottom = getDataFromLeftBottom(matrix, matrix.length, matrix[0].length);

		int[][] combined = new int[matrix.length][matrix[0].length];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				combined[i][j] = Math.min(Math.min(leftUp[i][j], rightUp[i][j]),
						Math.min(rightBottom[i][j], leftbottom[i][j]));
				res = Math.max(res, combined[i][j]);
			}
		}
		return res;
	}

	private int[][] getDataFromLeftUp(int[][] matrix, int row, int col) {
		int[][] leftUp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == 0) {
						leftUp[i][j] = 1;
					} else {
						leftUp[i][j] = leftUp[i - 1][j - 1] + 1;
					}
				}
			}
		}
		return leftUp;
	}

	private int[][] getDataFromRightUp(int[][] matrix, int row, int col) {
		int[][] rightUp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == col - 1) {
						rightUp[i][j] = 1;
					} else {
						rightUp[i][j] = rightUp[i - 1][j + 1] + 1;
					}
				}
			}
		}
		return rightUp;
	}

	private int[][] getDataFromRightBottom(int[][] matrix, int row, int col) {
		int[][] rightBottom = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 || j == col - 1) {
						rightBottom[i][j] = 1;
					} else {
						rightBottom[i][j] = rightBottom[i + 1][j + 1] + 1;
					}
				}
			}
		}
		return rightBottom;
	}

	private int[][] getDataFromLeftBottom(int[][] matrix, int row, int col) {
		int[][] leftBottom = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 || j == 0) {
						leftBottom[i][j] = 1;
					} else {
						leftBottom[i][j] = leftBottom[i + 1][j - 1] + 1;
					}
				}
			}
		}
		return leftBottom;
	}

	public static void main(String args[]) {
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		Q03_LongestX1s lc = new Q03_LongestX1s();
		System.out.println(lc.largest(matrix));
	}
}
