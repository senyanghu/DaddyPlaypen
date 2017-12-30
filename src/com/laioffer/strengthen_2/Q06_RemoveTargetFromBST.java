package com.laioffer.strengthen_2;

public class Q06_RemoveTargetFromBST {
	// how to remove a target value from BST
	// case 0: if root == null, return null
	// case 1: if target > root, root.right = delete(root.right, target)
	// case 2: if target < root, root.left = delete(root.left, target)
	// case 3: if target == root
	// 3.1: if root is a leaf, return null
	// 3.2: if root has only one child, return this child
	// 3.3: if root has two children
	// step 1: find the node with largest value in the left subtree
	// step 2: copy过来
	// step 3: recurse again to delete the node from the left sub tree
	public TreeNode delete(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		if (root.val < target) { // target is in the right sub tree
			root.right = delete(root.right, target);
		} else if (root.val > target) { // target is in the left sub tree
			root.left = delete(root.left, target);
		} else { // target is the root
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null || root.right == null) {
				return root.left == null ? root.right : root.left;
			} else {
				TreeNode smallest = findSmallest(root.right);
				root.val = smallest.val;
				root.right = delete(root.right, smallest.val);
			}
		}
		return root;
	}

	private TreeNode findSmallest(TreeNode root) {
		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
