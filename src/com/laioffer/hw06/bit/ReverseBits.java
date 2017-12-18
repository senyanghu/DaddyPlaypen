package com.laioffer.hw06.bit;

// how to reverse all bits of a number
// 11100 -> 00111
// xxxxx 0 xxxxxxxxxxx 1 xxxxx
//       i             j
// 00000 1 xxxxxxxxxxx 1 xxxxx  "XOR"
// case1: bit[i] == bit[j] do nothing
// case2: bit[i] != bit[j] flip respectively
public class ReverseBits {
	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
		return n;
	}

	public int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;

		if ((a ^ b) != 0) {
			n ^= ((1 << i) | (1 << j));
		}

		return n;
	}
}
