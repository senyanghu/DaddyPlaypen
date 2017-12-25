package com.laioffer.hw09.string_2;

import java.util.*;

public class Q08_LongestSubstringWithoutDup {
	// when to move fast: when we have not found any duplicate letters, [slow, fast]
	// no duplicates
	//
	// when to move slow: when we found duplicate, we keep moving slow, until...
	public int longestInClass(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}

		Map<Character, Integer> hashMap = new HashMap<>();
		int slow = 0;
		int longest = 0;

		for (int fast = 0; fast < input.length(); fast++) {
			char ch = input.charAt(fast);
			hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
			if (hashMap.get(ch) > 1) {
				while (hashMap.get(ch) > 1) {
					hashMap.put(input.charAt(slow), hashMap.get(input.charAt(slow)) - 1);
					slow++;
				}
			} else {
				longest = Math.max(longest, fast - slow + 1);
			}
		}
		return longest;
	}

	public int longest(String input) {
		if (input.length() == 0) {
			return 0;
		}

		Set<Character> characterSet = new HashSet<>();
		int slow = 0;
		int fast = 0;
		int longest = 0;

		while (fast < input.length()) {
			if (characterSet.contains(input.charAt(fast))) {
				characterSet.remove(input.charAt(slow++));
			} else {
				characterSet.add(input.charAt(fast++));
				longest = Math.max(longest, fast - slow);
			}
		}
		return longest;
	}

	public static void main(String args[]) {
		Q08_LongestSubstringWithoutDup lsw = new Q08_LongestSubstringWithoutDup();
		String input = "BDEFGADBE";
		System.out.println(lsw.longestInClass(input));
	}
}
