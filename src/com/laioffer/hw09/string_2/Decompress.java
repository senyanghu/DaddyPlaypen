package com.laioffer.hw09.string_2;

/**
 * 7.Decompress String II
 * 
 * Given a string in compressed form, decompress it to the original string. The
 * adjacent repeated characters in the original string are compressed to have
 * the character followed by the number of repeated occurrences. Assumptions The
 * string is not null The characters used in the original string are guaranteed
 * to be ‘a’ - ‘z’ There are no adjacent repeated characters with length > 9
 * Examples “a1c0b2c4” → “abbcccc”
 * 
 */
public class Decompress {
	public String decompress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		return decodeLong(array, decodeShort(array));
	}

	private String decodeLong(char[] input, int length) {
		int newLength = length;
		for (int i = 0; i < length; i++) {
			int digit = getDigit(input[i]);
			if (digit > 2 && digit <= 9) {
				newLength += digit - 2;
			}
		}
		char[] result = new char[newLength];
		int end = newLength - 1;
		for (int i = length - 1; i >= 0; i--) {
			int digit = getDigit(input[i]);
			if (digit > 2 && digit <= 9) {
				i--;
				for (int j = 0; j < digit; j++) {
					result[end--] = input[i];
				}
			} else {
				result[end--] = input[i];
			}
		}
		return new String(result);
	}

	private int getDigit(char input) {
		return input - '0';
	}

	private int decodeShort(char[] input) {
		int end = 0;
		for (int i = 0; i < input.length; i += 2) {
			int digit = getDigit(input[i + 1]);
			if (digit >= 0 && digit <= 2) {
				for (int j = 0; j < digit; j++) {
					input[end++] = input[i];
				}
			} else {
				input[end++] = input[i];
				input[end++] = input[i + 1];
			}
		}
		return end;
	}

	public static void main(String args[]) {
		Decompress de = new Decompress();
		String input = "a1c0b2c4";
		System.out.println(de.decompress(input));
	}
}
