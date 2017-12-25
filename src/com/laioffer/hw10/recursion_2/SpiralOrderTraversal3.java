package com.laioffer.hw10.recursion_2;

// Spiral Generate
public class SpiralOrderTraversal3 {
	public int[][] generateMatrix(int m, int n) {
		int[][] res = new int[m][n];
		int k = 1;

		int rowBegin = 0;
		int rowEnd = m - 1;
		int colBegin = 0;
		int colEnd = n - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// go right
			for (int j = colBegin; j <= colEnd; j++) {
				res[rowBegin][j] = k++;
			}
			rowBegin++;

			// go down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res[j][colEnd] = k++;
			}
			colEnd--;

			// go left
			if (rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					res[rowEnd][j] = k++;
				}
			}
			rowEnd--;

			// go up
			if (colBegin <= colEnd) {
				for (int j = rowEnd; j >= rowBegin; j--) {
					res[j][colBegin] = k++;
				}
			}
			colBegin++;
		}

		return res;
	}
}
