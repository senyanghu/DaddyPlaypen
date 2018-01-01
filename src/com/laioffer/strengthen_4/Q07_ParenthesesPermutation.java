package com.laioffer.strengthen_4;

import java.util.*;

public class Q07_ParenthesesPermutation {
	private static final char[] parenthese = new char[] { '(', ')', '[', ']', '{', '}' };

	public List<String> validParentheses(int l, int m, int n) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		int length = 2 * (l + m + n);
		int[] remain = new int[] { l, l, m, m, n, n };
		Deque<Character> stack = new LinkedList<>();
		StringBuilder cur = new StringBuilder();
		permutationHelper(remain, length, stack, cur, result);
		return result;
	}

	private void permutationHelper(int[] remain, int length, Deque<Character> stack, StringBuilder cur,
			List<String> result) {
		if (cur.length() == length) {
			result.add(cur.toString());
			return;
		}

		for (int i = 0; i < remain.length; i++) {
			if (i % 2 == 0) {
				if (remain[i] > 0) {
					cur.append(parenthese[i]);
					stack.offerFirst(parenthese[i]);
					remain[i]--;
					permutationHelper(remain, length, stack, cur, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == parenthese[i - 1]) {
					cur.append(parenthese[i]);
					stack.pollFirst();
					remain[i]--;
					permutationHelper(remain, length, stack, cur, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.offerFirst(parenthese[i - 1]);
					remain[i]++;
				}
			}
		}
	}
}
