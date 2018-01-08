package com.laioffer.hw12.sampling;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4
 * with equal probability. Use random5() to implement random7().
 */

class RandomFive {
	public static int random5() {
		return 0;
	}
}

// 可以用5的k次方做比5大的数字做一个random
public class Q03_Random7UsingRandom5 {
	public int random7() {
		// write your solution here
		// you can use RandomFive.random5() for generating
		// 0 - 4 with equal probability.
		while (true) {
			int random = 5 * RandomFive.random5() + RandomFive.random5();
			if (random < 21) {
				return random % 7;
			}
		}
	}
}
