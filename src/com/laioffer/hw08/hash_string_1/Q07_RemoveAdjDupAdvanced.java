package com.laioffer.hw08.hash_string_1;

import java.util.*;

/**
 * Repeatedly remove all adjacent, repeated characters in a ginve string from
 * left to right
 * 
 * abbbbaaccz -> aaaccz -> ccz -> z
 * 
 * look at the photo in 8-30 详情见八月三十日的那个照片 原题是用stack做
 * 但是这里高级的解法是用index去模拟stack的操作
 */
public class Q07_RemoveAdjDupAdvanced {
	public String removeDupWithStack(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		Deque<Character> deque = new LinkedList<>();
		int cursor = 0;
		while (cursor < input.length()) {
			char c = input.charAt(cursor);
			// c is not going to pushed in
			if (deque.size() > 0 && c == deque.peekFirst()) {
				while (cursor < input.length() && c == input.charAt(cursor)) {
					cursor++;
				}
				deque.pollFirst();
			} else { // c is going to pushed in
				deque.offerFirst(c);
				cursor++;
			}
		}
		char[] res = new char[deque.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = deque.pollFirst();
		}
		return new String(res);
	}

	public String deDep(String input) {
		// [0, left] means the final answer, left is pointing the top element
		if (input == null || input.length() == 0) {
			return input;
		}
		int left = -1;
		int right = 0;
		char[] charArray = input.toCharArray();

		while (right < charArray.length) {
			char c = charArray[right]; // current char
			if (left >= 0 && charArray[left] == c) { // stack has data
				while (right < charArray.length && c == charArray[right]) {
					right++;
				}
				left--; // stack pop
			} else {
				charArray[++left] = c;
				right++;
			}
		}
		return new String(charArray, 0, left + 1);
	}

	public static void main(String args[]) {
		Q07_RemoveAdjDupAdvanced rada = new Q07_RemoveAdjDupAdvanced();
		String input1 = "abbbbaaccz";
		System.out.println(rada.deDep(input1));
		System.out.println(rada.removeDupWithStack(input1));

		String input2 = "aabccdc";
		System.out.println(rada.deDep(input2));
		System.out.println(rada.removeDupWithStack(input2));
	}
}
