package hw9.string.laioffer.com;

public class ReverseWordsInSentence {

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
		ReverseWordsInSentence rwis = new ReverseWordsInSentence();
		String input = "I get Google";
		System.out.println(rwis.reverseWords(input));
	}
}
