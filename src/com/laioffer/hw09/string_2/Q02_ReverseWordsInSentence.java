package com.laioffer.hw09.string_2;

// step1: swap the whole sentence
// step2: swap every single word (two pointer)
public class Q02_ReverseWordsInSentence {

	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] charArray = input.toCharArray();

		this.reverse(charArray, 0, charArray.length - 1);

		int start = 0;
		for (int end = 0; end < input.length(); end++) {
			if (charArray[end] == ' ') {
				this.reverse(charArray, start, end - 1);
				start = end + 1;
			}
		}
		// reverse the last word
		this.reverse(charArray, start, charArray.length - 1);
		return new String(charArray);
	}

	private void reverse(char[] charArray, int i, int j) {
		while (i < j) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String args[]) {
		Q02_ReverseWordsInSentence rwis = new Q02_ReverseWordsInSentence();
		String input = "Senyang gets Amazon";
		System.out.println(rwis.reverseWords(input));
	}
}
