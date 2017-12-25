package com.laioffer.hw10.recursion_2;

/**
 * Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an
 * abbreviation, return if the string matches the abbreviation.
 * 
 * Assumptions: The original string only contains alphabetic characters. Both
 * input and pattern are not null.
 * 
 * Examples: pattern “s11d” matches input “sophisticated” since “11” matches
 * eleven chars “ophisticate”.
 */
// O(min(m, n))
public class Q05_StringAbbrMatching {
	public boolean match(String input, String pattern) {
		return matchHelper(input, 0, pattern, 0);
	}

	private boolean matchHelper(String input, int inputIndex, String pattern, int patternIndex) {
		if (inputIndex == input.length() && patternIndex == pattern.length()) {
			return true;
		}

		if (inputIndex >= input.length() || patternIndex >= pattern.length()) {
			return false;
		}

		// if the patternIndex points to a char
		if (pattern.charAt(patternIndex) > '9' || pattern.charAt(patternIndex) < '0') {
			if (input.charAt(inputIndex) == pattern.charAt(patternIndex)) {
				return matchHelper(input, inputIndex + 1, pattern, patternIndex + 1);
			} else {
				return false;
			}
		}

		int count = 0;
		while (patternIndex < pattern.length() && pattern.charAt(patternIndex) <= '9'
				&& pattern.charAt(patternIndex) >= '0') {
			count = count * 10 + pattern.charAt(patternIndex) - '0';
			patternIndex++;
		}
		return matchHelper(input, inputIndex + count, pattern, patternIndex);
	}
}
