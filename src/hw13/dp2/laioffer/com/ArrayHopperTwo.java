package hw13.dp2.laioffer.com;

/*
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * base case M[n - 1] = 0
 * 
 * Induction Rule
 * 		M[i] represents the minimum number of steps needed to reach the target from the i-th index
 * 		M[i] = 1 + min(Min[j]) where i <= j + input[j]
 *
 */
/**
 * 1.Array Hopper II Given an array A of non-negative integers, you are
 * initially positioned at index 0 of the array. A[i] means the maximum jump
 * distance from index i (you can only jump towards the end of the array).
 * Determine the minimum number of jumps you need to reach the end of array. If
 * you can not reach the end of the array, return -1.
 * 
 * Assumptions The given array is not null and has length of at least 1.
 * 
 * Examples {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then
 * to the end of array)
 * 
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in
 * this case.
 */
public class ArrayHopperTwo {
	private int minJumps(int[] arr) {
		int jumps[] = new int[arr.length];

		if (arr.length == 0 || arr[0] == 0) {
			return -1;// if first element is 0, end cannot be reached
		}

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (int i = 1; i < arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j]) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}
		return jumps[arr.length - 1] == Integer.MAX_VALUE ? -1 : jumps[arr.length - 1];
	}

	// driver program to test above function
	public static void main(String[] args) {
		ArrayHopperTwo aht = new ArrayHopperTwo();
		int arr1[] = { 3, 3, 1, 0, 4 };
		System.out.println("Minimum number of jumps to reach end is : " + aht.minJumps(arr1));

		int arr2[] = { 2, 1, 1, 0, 2 };
		System.out.println("Minimum number of jumps to reach end is : " + aht.minJumps(arr2));
	}
}