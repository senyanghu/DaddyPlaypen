package hw8.laioffer.com;

/**
 * remove adjacent, repeated characters in a given string, leaving only one
 * character for each group of such characters
 * 
 * 
 * aaaabbbbbc -> abc
 */
public class RemoveAdjDup {
	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		// [0, left) indicates the result array
		int left = 1;
		for (int cur = 1; cur < input.length(); cur++) {
			if (charArray[left - 1] != charArray[cur]) {
				charArray[left++] = charArray[cur];
			}
		}
		return new String(charArray, 0, left);
	}

	public static void main(String args[]) {
		RemoveAdjDup rad = new RemoveAdjDup();
		String input = "aaaabbbbbaaaac";
		System.out.println(rad.deDup(input));
	}
}
