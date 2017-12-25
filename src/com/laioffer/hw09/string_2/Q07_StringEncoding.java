package com.laioffer.hw09.string_2;

// aaaabccaaaaa -> a4b1c2a5
// AAAAaaaa -> A4a4

//  我这个还没有全部写完 还需要在一次出现的字母后面加上1
//  每次反过来来读的时候 应该是字母+数字的形式(a222) 
//  如果cursor指向的直接就是字母 那么说明这个字母只出现了一次
public class Q07_StringEncoding {
	public static String encode(String input) {
		// sanity check
		if (input == null || input.length() == 0) {
			return null;
		}
		char[] charArray = input.toCharArray();

		int slow = 0; // [0, slow) is the answer
		int fast = 0; // fast means the current cursor

		while (fast < input.length()) {
			char c = charArray[fast];
			int counter = 0;
			while (fast < input.length() && charArray[fast] == c) {
				fast++;
				counter++;
			}

			charArray[slow++] = c;
			if (counter >= 2) {
				charArray[slow++] = (char) (counter + '0');
			}
		}
		return new String(charArray, 0, slow);
	}

	public static void main(String args[]) {
		System.out.println(encode("aaaabccaaaaa"));
	}
}
