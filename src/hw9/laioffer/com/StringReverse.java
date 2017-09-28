package hw9.laioffer.com;

public class StringReverse {
	// assume the input is not NULL
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
}
