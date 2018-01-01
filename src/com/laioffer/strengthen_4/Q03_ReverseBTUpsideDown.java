package com.laioffer.strengthen_4;

import com.laioffer.hw04.bt_bst.TreeNode;

public class Q03_ReverseBTUpsideDown {

	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}

		TreeNode newRoot = reverse(root.left);
		root.left.right = root.right;
		root.left.left = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}
}
