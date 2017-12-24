package com.laioffer.hw08.hash_string_1;

// HashSet - but this is not cool
// XOR
// sequence1: 1 2 3 4 5 6
// sequence2: 1 2 3 4 X 6
// sequence1 XOR sequence2
// time = O(2n)
// space = O(1)
public class Q02_MissingNumber {
	public int miss(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int n = array.length + 1;
		int xor = 0;
		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}

		for (int number : array) {
			xor ^= number;
		}
		return xor;
	}
}
