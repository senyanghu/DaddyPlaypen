package com.laioffer.hw02.recursion1_bs;

// time complexity: O(2^n)
// space complexity: O(n) call stack的深度
public class Q01_Fibo {
	public long fibonacci(int k) {
		// base case
		if (k < 0) {
			return 0;
		} else if (k == 0 || k == 1) {
			return k;
		}
		return fibonacci(k - 1) + fibonacci(k - 2); // recursive rule
	}
}
