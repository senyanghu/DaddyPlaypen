package com.laioffer.strengthen_3.recursion_3;

/**
 * Given a binary tree in which each node contains an integer number.
 * Find the maximum possible sum from any node to any node 
 * (the start node and the end node can be the same).
 * Assumptions
 * The root of the given binary tree is not null

Examples
    -1
  /    \
2      11
     /    \
    6     -14
one example of paths could be -14 -> 11 -> -1 -> 2
another example could be the node 11 itself
The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
  /   \
 2     3
      /
    4
 */
public class Q03_MaxPathSumAnyNodeToAny {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] maxSum = {Integer.MIN_VALUE};
		maxPathSumHelper(root, maxSum);
		return maxSum[0];
	}

	private int maxPathSumHelper(TreeNode root, int[] maxSum) {
		if (root == null) {
			return 0;
		}
		int left = maxPathSumHelper(root.left, maxSum);
		int right = maxPathSumHelper(root.right, maxSum);
		
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		
		maxSum[0] = Integer.max(maxSum[0], left + root.key + right);
		
		return Math.max(left, right) + root.key;
	}
}

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
