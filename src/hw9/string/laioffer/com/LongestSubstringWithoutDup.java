package hw9.string.laioffer.com;

import java.util.*;

public class LongestSubstringWithoutDup {
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
}
