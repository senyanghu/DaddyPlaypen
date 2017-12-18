package com.laioffer.hw06.bit;

// Q1: determine whether a number is a power of 2 (x > 0)
// 有且只有一个bit是1

public class IsPowerOfTwoSolution {
	// solution 1
	// bit representation view of the integer value
	public boolean isPowerOfTwoMethod1(int x) {
		if (x <= 0) {
			return false;
		}
		int mask = 1;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((x & mask) == 1) {
				count += 1;
			}
			x = x >> 1;
		}
		return count == 1;
	}

	// solution 2
	// best solution
	public boolean isPowerOfTwoMethod2(int x) {
		return x > 0 && (x & x - 1) == 0;
	}
	
	// follow up 

	// solution 3 decimal view of number
	public boolean isPowerOfTwoMethod3(int number) {
		while (number > 1) {
			int y = number % 2;
			number = number / 2;
			if (y == 1) { // 不被二能整除
				return false;
			}
		}
		return true;
	}
}
