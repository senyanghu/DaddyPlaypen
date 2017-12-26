package com.laioffer.hw13.dp_2;

import java.util.*;

/**
 * 2.Dictionary Word I
 * 
 * Given a word and a dictionary, determine if it can be composed by
 * concatenating words from the given dictionary.
 * 
 * Assumptions
 * 
 * The given word is not null and is not empty The given dictionary is not null
 * and is not empty and all the words in the dictionary are not null or empty
 * Examples
 * 
 * Dictionary: {“bob”, “cat”, “rob”}
 * 
 * Word: “robob” return false
 * 
 * Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 * 
 * public class Solution { public boolean canBreak(String input, String[] dict)
 * { // Write your solution here. return false; } }
 */
public class Q03_DictionaryWordOne {
	// 左大段右小段
	// M[i] represents whether [0, i) can be broken into words in dict
	// base case: M[0] = false;
	// induction rule: M[i] = OR { M[j] && substring(j, i) }
	// time complexity: O(n^3)
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = this.buildSet(dict);
		boolean[] M = new boolean[input.length() + 1];

		for (int i = 1; i <= input.length(); i++) {
			// case 1: if the word ins in the dict, done
			if (dictSet.contains(input.substring(0, i))) {
				M[i] = true;
				continue;
			}

			// case 2: check the possible single splits (左大段右小段)
			for (int j = 1; j < i; j++) {
				if (M[j] && dictSet.contains(input.substring(j, i))) {
					M[i] = true;
					break;
				}
			}
		}

		return M[input.length()];
	}

	private Set<String> buildSet(String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (String str : dict) {
			dictSet.add(str);
		}
		return dictSet;
	}
}
