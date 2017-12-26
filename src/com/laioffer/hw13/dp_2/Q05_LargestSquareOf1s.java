package com.laioffer.hw13.dp_2;

public class Q05_LargestSquareOf1s {
	// https://discuss.leetcode.com/topic/18482/accepted-clean-java-dp-solution
	// leetcode - 221
	public int maximal(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int row = matrix.length;
		int col = matrix[0].length;

		// dp(i, j) represents the length of the square
		// whose lower-right corner is located at (i, j)
		// dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) } + 1
		int[][] dp = new int[row][col];

		// initialization
		for (int i = 0; i < row; i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
		}

		for (int j = 0; j < col; j++) {
			dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
		}

		// recurrence function
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (dp[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		// return the max number
		return max;
	}

}
