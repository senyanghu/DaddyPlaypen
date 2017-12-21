package com.laioffer.hw04.bt_bst;

import java.util.*;

public class Q05_TreeNodeWithinRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		this.getRangeHelper(root, min, max, res);
		return res;
	}

	public void getRangeHelper(TreeNode root, int min, int max, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (root.val > min) {
			this.getRangeHelper(root.left, min, max, res);
		}

		if (root.val >= min && root.val <= max) {
			res.add(root.val);
		}

		if (root.val < max) {
			this.getRangeHelper(root.right, min, max, res);
		}
	}
}
