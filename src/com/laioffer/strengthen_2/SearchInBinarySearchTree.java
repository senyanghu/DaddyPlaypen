package com.laioffer.strengthen_2;

public class SearchInBinarySearchTree {
	public TreeNode search(TreeNode root, int val) {
		while (root != null) {
			if (root.val == val) {
				return root;
			} else if (root.val > val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}
}
