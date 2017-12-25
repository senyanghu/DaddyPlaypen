package com.laioffer.hw09.string_2;

public class Q01_ReverseString {
	public String reverseRecursive(String input) {
		char[] charArray = input.toCharArray();
		reverseRecursiveHelp(charArray, 0, charArray.length - 1);
		return new String(charArray);
	}

	public void reverseRecursiveHelp(char[] inputChar, int left, int right) {
		if (left >= right) {
			return;
		}
		char temp = inputChar[left];
		inputChar[left] = inputChar[right];
		inputChar[right] = temp;
		reverseRecursiveHelp(inputChar, left + 1, right - 1);
	}

	// assume the input is not NULL
	// this is iterative method
	public String reverse(String input) {
		if (input.length() <= 1) {
			return input;
		}
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length / 2; i++) {
			swap(charArray, i, charArray.length - 1 - i);
		}
		return new String(charArray);
	}

	private void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}

	public static void main(String args[]) {
		Q01_ReverseString sr = new Q01_ReverseString();
		System.out.println(sr.reverseRecursive("jimmy"));
	}
}
