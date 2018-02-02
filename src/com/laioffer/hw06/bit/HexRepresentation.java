package com.laioffer.hw06.bit;

// given a non-negative int number x, how to get hex  representation
// 十进制   0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
// 十六进制  0, 1, 2, 4, 5, 6, 7, 8, 9,  A,  B,  C,  D,  E,  F
// 在java中 string是immu的 每次对string操作效率比较低
// 所以在java中 对string做cat之类的操作的时候 要用string builder
public class HexRepresentation {
	// assume num >= 0
	public String hex(int num) {
		if (num == 0) {
			return "0x0";
		}
		StringBuilder sb = new StringBuilder();
		int temp = num;
		while (temp != 0) {
			int mod = temp % 16;
			temp = temp / 16;
			if (mod < 10) {
				sb.append((char) (mod + '0')); // amortized O(1)
			} else {
				sb.append((char) (mod - 10 + 'A'));
			}
		}
		sb.append("x0");
		return sb.reverse().toString();
	}

	public static void main(String args[]) {
		HexRepresentation hr = new HexRepresentation();
		System.out.println(hr.hex(203));
	}
}
