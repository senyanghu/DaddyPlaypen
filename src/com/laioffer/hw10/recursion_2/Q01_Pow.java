package com.laioffer.hw10.recursion_2;

// corner cases:
// (1) a^a
// (2) denominator == 0
// (3) data type conversion (accuracy loss) int -> double
public class Q01_Pow {
	public double power(int a, int b) {
		if (a == 0 && b <= 0) {
			return 0;
		}

		return b < 0 ? 1 / powerHelper(a, -b) : powerHelper(a, b);
	}

	public double powerHelper(int a, int b) { // assume b >= 0
		if (b == 0) {
			return 1;
		}
		double half = powerHelper(a, b / 2);
		return b % 2 == 0 ? half * half : half * half * a;
	}
}
