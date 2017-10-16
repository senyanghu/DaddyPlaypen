package midterm2.laioffer.com;

/**
 * 
 * Given a string, a partitioning of the string is a palindrome partitioning if
 * every substring of the partition is a palindrome. Determine the fewest cuts
 * needed for a palindrome partitioning of a given string.
 * 
 * Assumptions: The given string is not null
 * 
 * “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
 * The minimum number of cuts needed is 3.
 */
public class MinimumCutsForPalindromes {
	public int minCuts(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		// M[i] is used to indicate the min cuts for a string from index 0 to index i
		int[] M = new int[input.length()];
		for (int i = 1; i < input.length(); i++) {
			M[i] = i;
			for (int j = i; j >= 0; j--) {
				if (isPalindrome(input, j, i)) {
					if (j == 0) {
						M[i] = 0;
					} else {
						M[i] = Integer.min(M[i], M[j - 1] + 1);
					}
				}
			}
		}
		return M[input.length() - 1];
	}

	private boolean isPalindrome(String input, int j, int i) {
		while (j < i) {
			if (input.charAt(j) != input.charAt(i)) {
				return false;
			}
			j++;
			i--;
		}
		return true;
	}

	public static void main(String args[]) {
		MinimumCutsForPalindromes mcfp = new MinimumCutsForPalindromes();
		System.out.println(mcfp.minCuts("ababbbabbababa"));
	}
}
