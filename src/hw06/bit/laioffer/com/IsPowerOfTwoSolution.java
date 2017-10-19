package hw06.bit.laioffer.com;

public class IsPowerOfTwoSolution {
	public boolean isPowerOfTwoMethod1(int number) {
		if (number <= 0) {
			return false;
		}
		int mask = 0;
		int count = 0;
		for (int i = 0; i < 31; i++) {
			if ((number & mask) == 1) {
				count += 1;
			}
			number >>= 1;
		}
		return count == 1;
	}

	public boolean isPowerOfTwoMethod2(int number) {
		return number > 0 && (number & number - 1) == 0;
	}
}
