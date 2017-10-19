package hw08.array.laioffer.com;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces
 *
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int slow = 0; // [0, slow) is the answer
		int cur = 0; // current cursor
		int wordCount = 0;

		while (true) {
			// skip white spaces
			while (cur < charArray.length && charArray[cur] == ' ') {
				cur++;
			}
			if (cur == charArray.length) {
				break; // we are done
			}
			if (wordCount > 0) {
				charArray[slow++] = ' '; // put one space before the second word
			}
			while (cur < charArray.length && charArray[cur] != ' ') {
				charArray[slow++] = charArray[cur++];
			}
			wordCount++;
		}
		return new String(charArray, 0, slow);
	}
}
