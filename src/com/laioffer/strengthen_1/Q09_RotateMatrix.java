package com.laioffer.strengthen_1;

/**
 * Rotate an N * N matrix clockwise 90 degrees. Assumptions
 * 
 * The matrix is not null and N >= 0
 * 
 * Examples { {1, 2, 3} {8, 9, 4}, {7, 6, 5} }
 * 
 * after rotation is { {7, 8, 1} {6, 9, 2}, {5, 4, 3} } 剥洋葱
 */
// lc - 48
public class Q09_RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		// this indicates how many rounds we need to do the clock wise rotation
		// round 0 -> 最外面一层
		// round 1 -> 往里面一层 ...
		int round = n / 2;

		for (int i = 0; i < round; i++) {
			for (int j = i; j <= n - i - 2; j++) {
				// int element1 = matrix[i][j];
				// int element2 = matrix[j][n - 1 - i];
				// int element3 = matrix[n - 1 - i][n - 1 - j];
				// int element4 = matrix[n - 1 - j][i];
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

	public static void rotateRecursively(int[][] matrix, int offset, int size) {
		if (size == 0 || size == 1) {
			return;
		}
		int length = matrix.length;
		for (int i = 0; i < size - 1; i++) {
			// 画全等三角形慢慢算
			int temp = matrix[offset][offset + i];
			matrix[offset][offset + i] = matrix[length - 1 - offset - i][offset];
			matrix[length - 1 - offset - i][offset] = matrix[length - 1 - offset][length - 1 - offset - i];
			matrix[length - 1 - offset][length - 1 - offset - i] = matrix[offset + i][length - 1 - offset];
			matrix[offset + i][length - 1 - offset] = temp;
		}
		rotateRecursively(matrix, offset + 1, size - 2);
	}

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		rotateRecursively(matrix, 0, 3);

	}
}
