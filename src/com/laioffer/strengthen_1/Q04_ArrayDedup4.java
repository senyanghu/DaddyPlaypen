package com.laioffer.strengthen_1;

/**
 * Given an unsorted integer array, remove adjacent duplicate elements
 * repeatedly, from left to right. For each group of elements with the same
 * value do not keep any of them. Do this in-place, using the left side of the
 * original array. Return the array after deduplication. Assumptions
 * 
 * The given array is not null
 * 
 * Examples {1, 2, 3, 3, 3, 2, 2} -> {1, 2, 2, 2} -> {1}, return {1}
 */
public class Q04_ArrayDedup4 {
	public String deDep(String input) {
		// [0, left] means the final answer, left is pointing the top element
		if (input == null || input.length() == 0) {
			return input;
		}
		int left = -1;
		int right = 0;
		char[] charArray = input.toCharArray();

		while (right < charArray.length) {
			char c = charArray[right]; // current char
			if (left >= 0 && charArray[left] == c) { // stack has data
				while (right < charArray.length && c == charArray[right]) {
					right++;
				}
				left--; // stack pop
			} else {
				charArray[++left] = c;
				right++;
			}
		}
		return new String(charArray, 0, left + 1);
	}
}
