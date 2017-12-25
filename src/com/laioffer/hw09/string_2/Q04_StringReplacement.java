package com.laioffer.hw09.string_2;

import java.util.*;

public class Q04_StringReplacement {
	// replace s with t in the input
	public String replace(String input, String s, String t) {
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] arrayInput = input.toCharArray();
		if (s.length() >= t.length()) { // s is longer, replace longer with shorter
			return replaceShorter(arrayInput, s, t);
		} else { // s is shorter, replace shorter with longer
			return replaceLonger(arrayInput, s, t);
		}
	}

	private boolean equalSubstring(char[] input, int index, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (input[i + index] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private void copySubstring(char[] input, int index, String t) {
		for (int i = 0; i < t.length(); i++) {
			input[index + i] = t.charAt(i);
		}
	}

	private String replaceShorter(char[] input, String s, String t) {
		int slowIndex = 0;
		int fastIndex = 0;
		while (fastIndex < input.length) {
			if (fastIndex <= input.length - s.length() && equalSubstring(input, fastIndex, s)) {
				copySubstring(input, slowIndex, t);
				slowIndex += t.length();
				fastIndex += s.length();
			} else {
				input[slowIndex++] = input[fastIndex++];
			}
		}

		return new String(input, 0, slowIndex);
	}

	private List<Integer> getAllMatches(char[] input, String s) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		while (i <= input.length - s.length()) {
			if (equalSubstring(input, i, s)) {
				result.add(i + s.length() - 1);
				i += s.length();
			} else {
				i++;
			}
		}
		return result;
	}

	private String replaceLonger(char[] input, String s, String t) {
		List<Integer> matches = getAllMatches(input, s);
		char[] result = new char[input.length + matches.size() * (t.length() - s.length())];

		int matchIndex = matches.size() - 1;
		int slowIndex = input.length - 1;
		int fastIndex = result.length - 1;

		while (slowIndex >= 0) {
			if (matchIndex >= 0 && slowIndex == matches.get(matchIndex)) {
				copySubstring(result, fastIndex - t.length() + 1, t);
				fastIndex -= t.length();
				slowIndex -= s.length();
				matchIndex--;
			} else {
				result[fastIndex--] = input[slowIndex--];
			}
		}
		return new String(result);
	}

	public static void main(String args[]) {
		Q04_StringReplacement sr = new Q04_StringReplacement();
		System.out.println(sr.replace("sentudent", "en", "XXX"));
	}
}
