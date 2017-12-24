package com.laioffer.hw08.hash_string_1;

// remove a/some particular chars from a string
// student, remove 'u' -> stdent
// slow, fast -> two pointers

import java.util.*;

// Remove given characters in input string, the relative order of other characters should be remained.
// Return the new string after deletion.
public class Q04_RemoveChar {
	public String remove(String input, String given) {
		if (given == null || given.length() == 0) {
			return input;
		}
		char[] inputArr = input.toCharArray();
		// [0, slowIndex) is the answer
		int slowIndex = 0;
		Set<Character> excludeSet = this.buildSet(given);

		for (int fastIndex = 0; fastIndex < inputArr.length; fastIndex++) {
			if (!excludeSet.contains(inputArr[fastIndex])) {
				inputArr[slowIndex++] = inputArr[fastIndex];
			}
		}

		return new String(inputArr, 0, slowIndex);
	}

	public Set<Character> buildSet(String str) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		return set;
	}
}