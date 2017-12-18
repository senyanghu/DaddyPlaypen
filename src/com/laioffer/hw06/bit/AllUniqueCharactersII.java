package com.laioffer.hw06.bit;

// determine whether a word contains all letters that are unique (no duplicates in letters)
// assume 26 lower case English letter
// method1 - hashSet - 空间效率不好 collision 对CPU的消耗还比较大
// method2 - boolean[26] - char[i] - 'a'
// method3 - 1 bit 0/1 - 用0和1对应false和true
// 0 0 0 0 ............ 0
//  ...           2  1  0
//  ...           c  b  a
public class AllUniqueCharactersII {
	public boolean allUnique(String word) {
		return true;
	}

	// 现在是26个
	public boolean allUnique(char[] array) {
		int mask = 1;
		int dict = 0; // 000...000

		for (int i = 0; i < array.length; i++) {
			int offset = array[i] - 'a';
			int shift = mask << offset;
			if ((shift & dict) != 0) { // 说明之前这个char已经见过了
				return false;
			} else {
				dict = dict | shift;
			}
		}
		return true;
	}

	// 扩展到256 bit vector
	// int bit_map[8] // 8 * 32 = 256 bits
	public boolean allUniqueFollowup(char[] array) {
		int mask = 1;
		int[] dict = new int[8]; // 000...000

		for (int i = 0; i < array.length; i++) {
			int offset = array[i];
			int row = offset / 32;
			int col = offset % 32;
			int shift = mask << col;
			if ((shift & dict[row]) != 0) { // 说明之前这个char已经见过了
				return false;
			} else {
				dict[row] = dict[row] | shift;
			}
		}
		return true;
	}
}