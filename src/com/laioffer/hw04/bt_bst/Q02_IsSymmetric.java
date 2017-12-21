package com.laioffer.hw04.bt_bst;

public class Q02_IsSymmetric {
	// time complexity is O(n)
	// space = O(height of recursion tree) = O(n/2) = O(n) worst case是一条直线
	// https://leetcode.com/articles/symmetric-tree/
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	public boolean isSymmetricLeetCode(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	// 比较完美的阐述了recursion问题的三个步骤
	// (1) sub problem: isSymmetric(l.left, r.right) isSymmetric(l.right, r.left)
	// (2) 当前层需要自己的做事情: l.val == r.val
	// (3) 边界条件判断: if (l == null && r == null) if (r == null || l == null)
	public boolean isSymmetricLeetCode(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
		if (l.val != r.val) {
			return false;
		}
		if (!isSymmetric(l.left, r.right)) {
			return false;
		}
		if (!isSymmetric(l.right, r.left)) {
			return false;
		}

		return true;
	}
}
