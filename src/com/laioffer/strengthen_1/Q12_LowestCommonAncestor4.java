package com.laioffer.strengthen_1;

import java.util.*;

/**
 * 
 *Given K nodes in a binary tree, find their lowest common ancestor.
Assumptions

	* K >= 2
	* There is no parent pointer for the nodes in the binary tree
	* The given K nodes are guaranteed to be in the binary tree

Examples
        5
      /   \
     9     12
   /  \      \
  2    3      14
The lowest common ancestor of 2, 3, 14 is 5
The lowest common ancestor of 2, 3, 9 is 9
 */
public class Q12_LowestCommonAncestor4 {
	public TreeNode lca(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> nodeSet = new HashSet<>(nodes);
		return lacHelper(root, nodeSet);
	}

	private TreeNode lacHelper(TreeNode root, Set<TreeNode> nodeSet) {
		if (root == null) {
			return root;
		}
		if (nodeSet.contains(root)) {
			return root;
		}
		
		TreeNode left = lacHelper(root.left, nodeSet);
		TreeNode right = lacHelper(root.right, nodeSet);
		
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}
