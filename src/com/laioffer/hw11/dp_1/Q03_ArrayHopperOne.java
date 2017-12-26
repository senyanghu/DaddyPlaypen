package com.laioffer.hw11.dp_1;

/**
 * Given an array A of non-negative integers, you are initially positioned at
 * index 0 of the array.
 * 
 * A[i] means the maximum jump distance from that position (you can only jump
 * towards the end of the array).
 * 
 * Determine if you are able to reach the last index. Assumptions The given
 * array is not null and has length of at least 1. Examples {1, 3, 2, 0, 3}, we
 * are able to reach the end of array(jump to index 1 then reach the end of the
 * array) {2, 1, 1, 0, 2}, we are not able to reach the end of array
 * 
 */
// 2, 3, 1, 1, 4
// base case: M[n - 1] = true
// induction rule:
// M[i] represents whether we could reach the target from i-th index
// M[i] = true, iff there exists a j, where M[j] = true and (j - i) <= input[i]
// = false, otherwise
public class Q03_ArrayHopperOne {
	public boolean canJumpUsingDP(int[] array) {
		boolean[] canJump = new boolean[array.length];
		canJump[array.length - 1] = true;

		for (int i = array.length - 2; i >= 0; i--) {
			canJump[i] = false;
			for (int j = array.length - 1; j > i; j--) {
				if (canJump[j] == true && (j - i) <= array[i]) {
					canJump[i] = true;
				}
			}
		}
		return canJump[0];
	}

	public boolean canJump(int[] array) {
		int max = 0;
		for (int i = 0; i <= max && i < array.length; i++) {
			max = Math.max(array[i] + i, max);
		}
		return max >= array.length - 1;
	}

	public static void main(String args[]) {
		Q03_ArrayHopperOne aho = new Q03_ArrayHopperOne();
		int[] array = { 2, 3, 1, 1, 4 };
		System.out.println(aho.canJumpUsingDP(array));
	}
}
