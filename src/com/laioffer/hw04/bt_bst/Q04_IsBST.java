package com.laioffer.hw04.bt_bst;

public class Q04_IsBST {
	// in order to deal with the corner cases, we enlarge the range of min and max
	// time = O(n)
	// space = O(height of recursion tree)
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long low, long high) {
		if (root == null) {
			return true;
		}

		if (root.val <= low || root.val >= high) {
			return false;
		}

		return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
	}
}
