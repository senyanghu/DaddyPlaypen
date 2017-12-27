package com.laioffer.hw14.dp_3;

public class Q00_LargestSubarraySum {
	// Largest Sum of a sub array
	// Index 0, 1, 2, 3, 4, 5, 6
	// Input 1, 2, 4,-1,-2,10,-1
	// M[i] 1, 3, 7, 6, 4,14,13
	//
	// Index 0, 1, 2, 3, 4, 5, 6
	// Input 1, 2, 4,-1,-12,10,-1
	// M[i] 1, 3, 7, 6, -6,10, 9
	//
	// 1. base case: M[0] = input[0]
	// 2. induction rule:
	// M[i] represents [from 0-th element to the i-th element] the largest sum of
	// the subarray [must include the i-th element], ending with input[i].
	// M[i] = M[i - 1] + input[i] iff M[i - 1] >= 0
	// M[i] = input[i]
	// Time = O(n) Space = O(n) -> O(1) if optimized
	public int getMaxVersion0(int[] s) {
		if (s == null || s.length == 0) {
			return 0;
		}
		int max = s[0];
		int[] M = new int[s.length];
		M[0] = s[0];
		for (int i = 1; i < s.length; i++) {
			if (M[i - 1] > 0) {
				M[i] = M[i - 1] + s[i];
			} else {
				M[i] = s[i];
			}
			max = Math.max(max, M[i]);
		}
		return max;
	}

	// space optimized version
	public int getMaxVersion1(int[] s) {
		if (s == null || s.length < 1) {
			return 0;
		}
		int max = s[0];
		int lastMax = s[0];
		for (int i = 1; i < s.length; i++) {
			if (lastMax > 0) {
				lastMax = lastMax + s[i];
			} else {
				lastMax = s[i];
			}
			max = Math.max(max, lastMax);
		}
		return max;
	}

	// FollowUp: What if you are requested to return the let and right index of the
	// subarray that has the largest sum.
	// Four variable: L, R, Sol_L, Sol_R
	// When to update sol_L? ----> when max is updated
	// When to update sol_R? ----> when max is updated
	// When to update L? ----> L = i, when M[i - 1] < 0
	// When to update R? ----> Update all the time each round
	public int[] getMaxVersion2(int[] s) {
		if (s == null || s.length < 1) {
			return null;
		}
		int max = s[0];
		int lastMax = s[0];
		int sol_L = 0;
		int sol_R = 0;
		int l = 0;
		int r = 0;
		for (int i = 1; i < s.length; i++) {
			if (lastMax < 0) {
				l = i;
				r = i;
				lastMax = s[i];
			} else {
				lastMax = lastMax + s[i];
				r = i;
			}
			if (lastMax > max) {
				sol_L = l;
				sol_R = r;
				max = lastMax;
			}
		}
		return new int[] { sol_L, sol_R };
	}

	public int largest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int[] sum = new int[array.length];
		sum[0] = array[0];
		int max = sum[0];
		for (int i = 1; i < array.length; i++) {
			sum[i] = Integer.max(array[i], array[i] + sum[i - 1]);
			max = Integer.max(max, sum[i]);
		}
		return max;
	}

	public int largest2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int cur = array[0];
		int max = cur;
		for (int i = 1; i < array.length; i++) {
			cur = Integer.max(array[i], array[i] + cur);
			max = Integer.max(max, cur);
		}
		return max;
	}

	public int largest3(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int cur = array[0];
		int max = cur;

		int start = 0;
		int end = 0;
		int startRes = 0;
		int endRes = 0;

		for (int i = 1; i < array.length; i++) {
			if (cur < 0) {
				cur = array[i];
				start = i;
			} else {
				cur = array[i] + cur;
			}

			end = i;
			if (cur > max) {
				max = cur;
				startRes = start;
				endRes = end;
			}
		}
		System.out.println(startRes);
		System.out.println(endRes);
		return max;
	}
}
