package com.laioffer.hw10.recursion_2;

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
}

// case1: if both sides are null, return null
// case2: one side return not null, and the other side is null, return non-null side
// case3: if both sides are not null, return root
public class Q06_LowestCommonAncestor {
	public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		}
		if (root == one || root == two) {
			return root;
		}
		TreeNode left = lca(root.left, one, two);
		TreeNode right = lca(root.right, one, two);

		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else {
			return left;
		}
	}
}
