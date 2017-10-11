package hw13.dp2.laioffer.com;

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
public class DictionaryWordOne {
	// 左大段右小段
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = this.buildSet(dict);
		boolean[] M = new boolean[input.length() + 1];

		/*
		 * M[i] stands for whether subarray(0, i) can be segmented into words from the
		 * dictionary. So M[0] means whether subarray(0, 0) (which is an empty string)
		 * can be segmented, and of course the answer is yes.
		 */
		M[0] = true;
		for (int i = 1; i <= input.length(); i++) {
			for (int j = 0; j < i; j++) {
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
