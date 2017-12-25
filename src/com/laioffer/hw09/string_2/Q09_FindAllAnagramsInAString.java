package com.laioffer.hw09.string_2;

import java.util.*;

/**
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 */
public class Q09_FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length()) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// the number of types of letters to map
		int counter = map.size();
		int begin = 0;

		for (int fast = 0; fast < s.length(); fast++) {
			char ch = s.charAt(fast);

			if (fast >= t.length()) {
				char chToDelete = s.charAt(begin);
				if (map.containsKey(chToDelete) && map.get(chToDelete) == 0) {
					counter++;
				}
				map.put(chToDelete, map.get(chToDelete) + 1);
				begin++;
			}
			
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
			}
			if (map.get(ch) == 0) {
				counter--;
			}
			if (counter == 0) {
				result.add(begin);
			}

		}
		return result;
	}

	public List<Integer> findAnagramsOld(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length()) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// the number of types of letters to map
		int counter = map.size();
		int begin = 0;

		for (int fast = 0; fast < s.length(); fast++) {
			char ch = s.charAt(fast);
			if (fast < t.length()) {
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) - 1);
				}
				if (map.get(ch) == 0) {
					counter--;
				}
				if (counter == 0) {
					result.add(begin);
				}
			} else { // fast >= t.length
				char chToDelete = s.charAt(begin);
				if (map.containsKey(chToDelete) && map.get(chToDelete) == 0) {
					counter++;
				}
				map.put(chToDelete, map.get(chToDelete) + 1);
				begin++;

				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) - 1);
				}
				if (map.get(ch) == 0) {
					counter--;
				}
				if (counter == 0) {
					result.add(begin);
				}
			}
		}

		return result;
	}

	public static void main(String args[]) {
		String s = "aaaaaa";
		String p = "aa";

		Q09_FindAllAnagramsInAString sol = new Q09_FindAllAnagramsInAString();
		List<Integer> res = sol.findAnagrams(s, p);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
