package com.laioffer.strengthen_3.recursion_3;

import java.util.*;

// Node and Node can only be the path from root to one of the leaf nodes
public class Q05_SumNodeToNodeEqualToTarget {
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}

		List<TreeNode> path = new ArrayList<>();

		return helper(root, path, target);
	}

	private boolean helper(TreeNode root, List<TreeNode> path, int target) {
		path.add(root);

		int temp = 0;

		for (int i = path.size() - 1; i >= 0; i--) {
			temp += path.get(i).key;
			if (temp == target) {
				return true;
			}
		}

		if (root.left != null && helper(root.left, path, target)) {
			return true;
		}

		if (root.right != null && helper(root.right, path, target)) {
			return true;
		}

		path.remove(path.size() - 1);
		return false;
	}
}
