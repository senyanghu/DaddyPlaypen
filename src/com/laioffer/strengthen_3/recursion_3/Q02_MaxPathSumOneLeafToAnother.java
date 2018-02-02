package com.laioffer.strengthen_3.recursion_3;

/*
 * Find the max possible sum from one leaf node to another
 */
public class Q02_MaxPathSumOneLeafToAnother {

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int[] maxSum = new int[] { Integer.MIN_VALUE };
		maxPathSumHelper(root, maxSum);
		return maxSum[0];
	}

	private int maxPathSumHelper(TreeNode root, int[] maxSum) {
		if (root == null) {
			return 0;
		}

		int left = maxPathSumHelper(root.left, maxSum);
		int right = maxPathSumHelper(root.right, maxSum);
		
		// 左边和右边都不为空 才能update 这样才能构成一个leaf到另一个leaf的基本要求
		if (root.left != null && root.right != null) {
			maxSum[0] = Math.max(maxSum[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		}

		return root.left == null ? right + root.key : left + root.key;
	}

}
