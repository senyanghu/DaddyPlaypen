package hw11.dp1.laioffer.com;

// 0 1 2 3 4 5 6 7
// 7 2 3 1 5 8 9 6
// 1 1 2 1 2 3 4 1
// base case M[0] = 1
// M[i] represents the length of Longest Ascending subarray from 0-th to i-th element including i-th element
// M[i] = 1 + M[i - 1] iff input[i] > input[i - 1]
// M[i] = 1 				otherwise
public class LongestAscendingSubarray {
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] M = new int[array.length];
		M[0] = 1;
		int largest = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				M[i] = M[i - 1] + 1;
			} else {
				M[i] = 1;
			}
			largest = M[i] > largest ? M[i] : largest;
		}
		return largest;
	}

	public static void main(String args[]) {
		LongestAscendingSubarray las = new LongestAscendingSubarray();
		int[] input = { 7, 2, 3, 1, 5, 8, 9, 6 };
		System.out.println(las.longest(input));
	}
}
