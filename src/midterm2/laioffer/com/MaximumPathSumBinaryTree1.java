package midterm2.laioffer.com;

/**
 * 
 * Given a binary tree in which each node contains an integer number. 
 * Find the maximum possible sum from one leaf node to another leaf node. 
 * If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
Examples
  -15
  /    \
2      11
     /    \
    6     14
The maximum path sum is 6 + 11 + 14 = 31.
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
public class MaximumPathSumBinaryTree1 {
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
		
		if (root.left != null && root.right != null) {
			maxSum[0] = Integer.max(maxSum[0], left + root.key + right);
			return Integer.max(left, right) + root.key;
		}
		
		return root.left == null ? right + root.key : left + root.key;
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
