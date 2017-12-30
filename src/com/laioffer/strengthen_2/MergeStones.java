package com.laioffer.strengthen_2;

/**
 * We have a list of piles of stones, each pile of stones has a certain weight,
 * represented by an array of integers.
 * 
 * In each move, we can merge two adjacent piles into one larger pile, the cost
 * is the sum of the weights of the two piles. We merge the piles of stones
 * until we have only one pile left.
 * 
 * Determine the minimum total cost. Assumptions stones is not null and is
 * length of at least 1 Examples {4, 3, 3, 4}, the minimum cost is 28 merge
 * first 4 and first 3, cost 7 merge second 3 and second 4, cost 7 merge two 7s,
 * cost 14 total cost = 7 + 7 + 14 = 28
 */
public class MergeStones {
	public int minCost(int[] stones) {
		int length = stones.length;
		
		if (length == 1) {
			return 0;
		}

		int[][] cost = new int[length][length];
		int[][] sum = new int[length][length];

		for (int end = 0; end < length; end++) {
			for (int start = end; start >= 0; start--) {
				if (start == end) {
					cost[start][end] = 0;
					sum[start][end] = stones[start];
				} else {
					sum[start][end] = sum[start][end - 1] + stones[end];
					cost[start][end] = Integer.MAX_VALUE;
					for (int k = start; k < end; k++) {
						cost[start][end] = Math.min(cost[start][end],
								cost[start][k] + cost[k + 1][end] + sum[start][end]);
					}
				}
			}
		}
		return cost[0][length - 1];
	}
}
