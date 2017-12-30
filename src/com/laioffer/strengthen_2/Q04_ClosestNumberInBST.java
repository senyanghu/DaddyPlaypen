package com.laioffer.strengthen_2;

// In a binary search tree, find the node containing the closest number to the given target number.
// lc - 270
public class Q04_ClosestNumberInBST {
	public int closestValue(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(res - target)) {
				res = root.val;
			}
			root = target > root.val ? root.right : root.left;
		}
		return res;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}