package com.laioffer.hw08.hash_string_1;

/**
 * Assume both large and small are not NULL and if small is empty, return 0;
 */

// Robin-Karp Algorithm
public class Q08_IsSubstring {
	public int strStr(String large, String small) {
		if (small.length() == 0) {
			return 0;
		}

		for (int i = 0; i <= large.length() - small.length(); i++) {
			int j = 0;
			for (; j < small.length(); j++) {
				if (large.charAt(i) != small.charAt(j)) {
					break;
				}
			}
			if (j == small.length()) {
				return i;
			}
		}
		return -1;
	}
}
