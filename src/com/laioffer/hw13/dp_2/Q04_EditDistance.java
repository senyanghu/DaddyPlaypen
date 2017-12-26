package com.laioffer.hw13.dp_2;

public class Q04_EditDistance {
	public int editDistance(String word1, String word2) {
		// Use M[i][j] to represent the shortest edit distance
		// between word1[0,i) and word2[0, j).
		// (the first i letters from word1, the first j letters from word2)
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] M = new int[l1 + 1][l2 + 1];
		for (int j = 0; j <= l2; j++) {
			M[0][j] = j; // delete all chars in word2
		}
		for (int i = 0; i <= l1; i++) {
			M[i][0] = i; // delete all chars in word1
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else {
					int replace = M[i - 1][j - 1] + 1;
					int delete = M[i - 1][j] + 1; // delete i-th letter in word1
					int insert = M[i][j - 1] + 1; // insert a new char to the right of word1
					M[i][j] = Math.min(replace, Math.min(delete, insert));
				}
			}
		}
		return M[l1][l2];
	}
}
