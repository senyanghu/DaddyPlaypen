package com.laioffer.strengthen_7;

import java.util.*;

class PairComparator implements Comparator<int[]> {
	public int compare(int[] pair1, int[] pair2) {
		if (pair1[0] == pair2[0]) {
			return 0;
		} else if (pair1[0] < pair2[0]) {
			return -1;
		} else {
			return 1;
		}
	}
}

class Solution {

	public int findLongestChain(int[][] pairs) {
		Deque<Integer> deque = new LinkedList<>();
		if (pairs == null || pairs.length == 0)
			return 0;
		// Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		Arrays.sort(pairs, new PairComparator());
		int[] dp = new int[pairs.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
			}
		}
		return dp[pairs.length - 1];
	}
}