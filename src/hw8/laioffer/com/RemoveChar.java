package hw8.laioffer.com;

// remove a/some particular chars from a string
// student, remove 'u' -> stdent
// slow, fast -> two pointers

// "____abc__de___f_____"
// "abc_de_f"
// i: slow all letter to the left-hand side of i are the results to return
// j: fast current index

// (1) for all non-space, copy all non-space (words)
// (2) for all space, only copy 1 empty space

import java.util.*;

// Remove given characters in input string, the relative order of other characters should be remained.
// Return the new string after deletion.
public class RemoveChar {
	public String remove(String input, String given) {
		if (given == null || given.length() == 0) {
			return input;
		}
		char[] inputArr = input.toCharArray();
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