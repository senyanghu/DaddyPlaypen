package com.laioffer.hw08.hash_string_1;

/**
 * remove adjacent, repeated characters in a given string, leaving only one
 * character for each group of such characters
 * 
 * 
 * aaaabbbbbc -> abc
 */
// slow: all letters to the left hand side of input are the results to return
// (excluding slow)
// fast: current index
public class Q06_RemoveAdjDup {
	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		// [0, left) indicates the result array
		int left = 1;
		for (int cur = 1; cur < input.length(); cur++) {
			if (charArray[left - 1] != charArray[cur]) {
				charArray[left++] = charArray[cur];
			}
		}
		return new String(charArray, 0, left);
	}

	public static void main(String args[]) {
		Q06_RemoveAdjDup rad = new Q06_RemoveAdjDup();
		String input = "aaaabbbbbaaaac";
		System.out.println(rad.deDup(input));
	}
}
