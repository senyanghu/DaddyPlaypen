package com.laioffer.strengthen_3.recursion_3;

/**
 * Given a binary tree in which each node contains an integer number. Find the
 * maximum possible subpath sum(both the starting and ending node of the subpath
 * should be on the same path from root to one of the leaf nodes, and the
 * subpath is allowed to contain only one node).
 *
 */
public class Q06_MaxSubPath {
	// DP
	// O(n)
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] maxSum = { Integer.MIN_VALUE };
		maxPathSumHelper(root, 0, maxSum);
		return maxSum[0];
	} 

	private void maxPathSumHelper(TreeNode root, int prefixSum, int[] maxSum) {
		if (root == null) {
			return;
		}

		prefixSum = prefixSum < 0 ? root.key : prefixSum + root.key;

		maxSum[0] = Integer.max(maxSum[0], prefixSum);

		maxPathSumHelper(root.left, prefixSum, maxSum);
		maxPathSumHelper(root.right, prefixSum, maxSum);
	}

	// 三部曲
	// O(n)
	public int maxPathSumMethod2(TreeNode root) {
		// Write your solution here.
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		int left = helper(root.left, max);
		int right = helper(root.right, max); // step 1

		int temp = Math.max(Math.max(left, right), 0);
		max[0] = Math.max(max[0], temp + root.key); // step 2

		return temp + root.key; // step 3
	}
}
