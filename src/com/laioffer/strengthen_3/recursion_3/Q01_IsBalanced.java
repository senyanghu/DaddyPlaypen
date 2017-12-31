package com.laioffer.strengthen_3.recursion_3;

import com.laioffer.hw04.bt_bst.TreeNode;

// optimal solution
public class Q01_IsBalanced {
	public boolean isBalanced(TreeNode root) {
		int res = this.getHeight(root);
		if (res >= 0) {
			return true; // this tree is balanced
		} else {
			return false; // this tree is not balanced
		}
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left); // step 1
		int rightHeight = getHeight(root.right);

		// 三种不balanced的情况 // step 2
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1; // step 3
	}
}
