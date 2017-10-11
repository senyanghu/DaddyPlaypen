package hw13.dp2.laioffer.com;

public class EditDistance {
	public int editDistance(String word1, String word2) {
		// Use M[i][j] to represent the shortest edit distance
		// between word1[0,i) and word2[0, j).
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
					int delete = M[i - 1][j] + 1;
					int insert = M[i][j - 1] + 1;
					M[i][j] = Math.min(replace, Math.min(delete, insert));
				}
			}
		}
		return M[l1 - 1][l2 - 1];
	}
}
