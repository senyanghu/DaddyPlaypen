package com.laioffer.strengthen_2;

// 在所有的比target小的node中 找个最大的 矮子里拔将军
public class Q05_LargestNumberSmallerInBST {
	public int largestSmaller(TreeNode root, int target) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (root.val < target) {
				target = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return res;
	}
}
