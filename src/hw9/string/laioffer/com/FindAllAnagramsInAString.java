package hw9.string.laioffer.com;

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
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length()) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int counter = map.size();

		int begin = 0, end = 0;

		while (end < s.length()) {

			char c = s.charAt(end); // get a character

			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);// plus or minus one
				if (map.get(c) == 0) {
					counter--;// modify the counter according the requirement(different condition).
				}
			}
			end++;

			while (counter == 0) {
				if (end - begin == t.length()) {
					result.add(begin);
				}
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				begin++;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		String s = "aaaaaa";
		String p = "aa";

		FindAllAnagramsInAString sol = new FindAllAnagramsInAString();
		List<Integer> res = sol.findAnagrams(s, p);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
