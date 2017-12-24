package com.laioffer.hw08.hash_string_1;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces
 *
 */
// "____abc__de___f_____"
// "abc_de_f"
// i: slow all letter to the left-hand side of i are the results to return
// j: fast current index

// (1) for all non-space, copy all non-space (words)
// (2) for all space, only copy 1 empty space before each word (except the first word)
// 一个word前面都要加一个空格(除了第一个)
public class Q05_RemoveSpaces {
	public String removeSpaces(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int slow = 0; // [0, slow) is the answer
		int cur = 0; // current cursor
		int wordCount = 0; // special case for the 1st word

		while (true) {
			// skip all leading white spaces in front of each word
			while (cur < charArray.length && charArray[cur] == ' ') {
				cur++;
			}
			if (cur == charArray.length) {
				break; // we are done
			}
			if (wordCount > 0) {
				charArray[slow++] = ' '; // put one space before the second word (2nd+)
			}
			while (cur < charArray.length && charArray[cur] != ' ') {
				charArray[slow++] = charArray[cur++];
			}
			wordCount++;
		}
		return new String(charArray, 0, slow);
	}
}
