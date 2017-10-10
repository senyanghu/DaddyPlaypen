package hw12.sampling.laioffer.com;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4
 * with equal probability. Use random5() to implement random7().
 */

class RandomFive {
	public static int random5() {
		return 0;
	}
}

public class Random7UsingRandom5 {
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
