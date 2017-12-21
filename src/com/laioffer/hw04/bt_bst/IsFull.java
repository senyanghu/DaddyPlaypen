package com.laioffer.hw04.bt_bst;

// check the URL: http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
// full tree means all nodes have either zero or two child nodes
public class IsFull {
	public boolean isFullTree(TreeNode node) {
		// if empty tree
		if (node == null) {
			return true;
		}

		// if leaf node
		if (node.left == null && node.right == null) {
			return true;
		}

		// if both left and right subtrees are not null
		// they are full
		if ((node.left != null) && (node.right != null)) {
			return (isFullTree(node.left) && isFullTree(node.right));
		}

		// if none work
		return false;
	}

	public boolean isFullTreeSecond(TreeNode node) {
		// if empty tree
		if (node == null) {
			return true;
		}

		// if leaf node
		if (node.left == null && node.right == null) {
			return true;
		}

		// if one child is null
		if (node.left == null || node.right == null) {
			return false;
		}

		boolean isLeftFull = isFullTreeSecond(node.left);
		boolean isRightFull = isFullTreeSecond(node.right);

		return isLeftFull && isRightFull;
	}
}
