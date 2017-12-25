package com.laioffer.hw09.string_2;

/**
 * 2.Right Shift By N Characters Right shift a given string by n characters.
 * 
 * Assumptions
 * 
 * The given string is not null. n >= 0.
 */
public class Q03_RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if (input == null || input.length() == n || input.length() <= 1) {
			return input;
		}
		n = n % input.length();
		char[] charArray = input.toCharArray();
		reverse(charArray, 0, charArray.length - 1 - n);
		reverse(charArray, charArray.length - n, charArray.length - 1);
		reverse(charArray, 0, charArray.length - 1);

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
}
