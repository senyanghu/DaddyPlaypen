package hw06.bit.laioffer.com;

public class DiffBitsSolution {
	public int diffBits(int a, int b) {
		int diff = a ^ b;

		// count how many 1 in diff
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count += diff & 1;
			diff >>= 1;
		}
		return count;
	}
}