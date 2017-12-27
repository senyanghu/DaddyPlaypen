package com.laioffer.hw14.dp_3;

// 一个unsorted一维数组最长连续1的问题
// {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3
// M[i] represents the longest contiguous 1s from 0th to ith element (including the ith element)

// base case M[0] = A[0]
// induction rule: M[i] = M[i-1] + 1; if A[i] == 1
//					   = 0
public class Q01_LongestConsecutive1s {
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int curLength = array[0];
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] == 1) {
				curLength = curLength + 1;
			} else {
				curLength = 0;
			}
			result = Math.max(result, curLength);
		}
		return result;
	}
}
