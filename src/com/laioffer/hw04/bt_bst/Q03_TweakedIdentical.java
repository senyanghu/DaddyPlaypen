package com.laioffer.hw04.bt_bst;

// 照片八月十七日
// there are log2(n) levels
// Time Complexity: total nodes in this tree
// 4 ^ (log2(n)) = n^2
// 如果input tree is not balanced 那么原本的四叉树就可以伸出的叉就会变少 相当于pruning 那么就会时间复杂度会降低
public class Q03_TweakedIdentical {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null || two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.val != two.val) {
			return false;
		}
		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
				|| isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
	}
}
