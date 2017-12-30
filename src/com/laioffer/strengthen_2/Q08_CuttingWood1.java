package com.laioffer.strengthen_2;

/**
 * 
 * There is a wooden stick with length L >= 1, we need to cut it into pieces,
 * where the cutting positions are defined in an int array A.
 * 
 * The positions are guaranteed to be in ascending order in the range of [1, L -
 * 1].
 * 
 * The cost of each cut is the length of the stick segment being cut.
 * 
 * Determine the minimum total cost to cut the stick into the defined pieces.
 * 
 * Examples L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20
 * (cut at 4 first then cut at 2 and cut at 7)
 */
public class Q08_CuttingWood1 {
	public int minCost(int[] cuts, int length) {
		int[] helperCuts = new int[cuts.length + 2];
		helperCuts[0] = 0;
		for (int i = 1; i <= cuts.length; i++) {
			helperCuts[i] = cuts[i - 1];
		}
		helperCuts[helperCuts.length - 1] = length;

		int[][] minCost = new int[helperCuts.length][helperCuts.length];

		for (int end = 1; end < helperCuts.length; end++) {
			for (int start = end - 1; start >= 0; start--) {
				if (start + 1 == end) {
					minCost[start][end] = 0;
				} else {
					minCost[start][end] = Integer.MAX_VALUE;
					for (int k = start + 1; k < end; k++) {
						minCost[start][end] = Math.min(minCost[start][end],
								minCost[start][k] + minCost[k][end] + helperCuts[end] - helperCuts[start]);
					}
				}
			}
		}

		return minCost[0][helperCuts.length - 1];
	}
}
