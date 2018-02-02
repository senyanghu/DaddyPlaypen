package com.laioffer.strengthen_3.recursion_3;

public class Q04_MaxPathSumRootToLeaf {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] maxSum = {Integer.MIN_VALUE};
		maxPathSumHelper(root, 0, maxSum);
		return maxSum[0];
	}

	private void maxPathSumHelper(TreeNode root, int prefixSum, int[] maxSum) {
		if (root == null) {
			return;
		}
		
		prefixSum = prefixSum + root.key;
		
		if (root.left == null && root.right == null) {
			maxSum[0] = Integer.max(maxSum[0], prefixSum);
			return;
		}
		
		maxPathSumHelper(root.left, prefixSum, maxSum);
		maxPathSumHelper(root.right, prefixSum, maxSum);
	}
}
