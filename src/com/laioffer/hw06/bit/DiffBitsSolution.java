package com.laioffer.hw06.bit;

// Q2: determine the number of bits that are different between two integers
//    a = 00 00 1000
//    b = 00 11 0111 "XOR"
// diff = 00 11 1111
public class DiffBitsSolution {
	public int diffBits(int a, int b) {
		int diff = a ^ b;

		// count how many 1 in diff
		int count = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			count += (diff & mask);
			diff = diff >> 1;
		}
		return count;
	}
}

// Q3 what happens if we assign a negative number to an unsigned integer?
