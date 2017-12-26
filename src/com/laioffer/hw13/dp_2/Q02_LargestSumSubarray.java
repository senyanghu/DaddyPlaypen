package com.laioffer.hw13.dp_2;

// base case: M[i] = array[i]
// induction rule:
// M[i] represents the largest sum of subarray ending with i-th number
// M[i] = M[i - 1] + array[i]     if M[i - 1] >= 0
//      = array[i]         	     otherwise
public class Q02_LargestSumSubarray {
	public int largest(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int[] M = new int[nums.length];
		M[0] = nums[0];
		int largest = M[0];

		for (int i = 1; i < nums.length; i++) {
			if (M[i - 1] >= 0) {
				M[i] = M[i - 1] + nums[i];
			} else {
				M[i] = nums[i];
			}
			largest = Integer.max(largest, M[i]);
		}

		return largest;
	}

	public static void main(String args[]) {
		Q02_LargestSumSubarray lss = new Q02_LargestSumSubarray();
		int[] nums = { 1, 2, 4, -1, -12, 10, -1 };
		System.out.println(lss.largest(nums));
	}
}
