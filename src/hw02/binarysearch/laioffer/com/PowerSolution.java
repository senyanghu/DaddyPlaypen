package hw02.binarysearch.laioffer.com;

public class PowerSolution {
	public long power(int a, int b) {
		if (b == 0) {
			return a;
		} else if (b % 2 == 1) {
			return a * power(a, b / 2) * power(a, b / 2);
		} else {
			return power(a, b / 2) * power(a, b / 2);
		}
	}
}
