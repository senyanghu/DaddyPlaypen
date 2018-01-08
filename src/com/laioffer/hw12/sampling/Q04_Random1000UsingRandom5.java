package com.laioffer.hw12.sampling;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4
 * with equal probability. Use random5() to implement random7().
 */

public class Q04_Random1000UsingRandom5 {
	public int random1000() {
		// write your solution here
		// you can use RandomFive.random5() for generating
		// 0 - 4 with equal probability.
		while (true) {
			int random = 0;
			for (int i = 0; i < 5; i++) {
				random = (int) (5 * random + RandomFive.random5());
			}

			if (random < 3000) {
				return random % 1000;
			}
		}
	}
}
