package hw02.laioffer.com;

public class FiboSolution {
	public long fibonacci(int k) {
		if (k < 0) {
			return 0;
		}
		else if (k == 0 || k == 1) {
			return k;
		}
		return fibonacci(k-1) + fibonacci(k-2);
	}
}
