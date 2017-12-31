package com.laioffer.strengthen_3.recursion_3;

import java.util.*;

public class Q09_ReconstructFromPostAndIn {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inEnd = inorder.length - 1;
		int postEnd = postorder.length - 1;
		Map<Integer, Integer> positionMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			positionMap.put(inorder[i], i);
		}
		return buildTree(inorder, 0, inEnd, postorder, 0, postEnd, positionMap);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
			Map<Integer, Integer> positionMap) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);

		int rootIndex = positionMap.get(root.key);

		int len = rootIndex - inStart; // left size

		root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + len - 1, positionMap);
		root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + len, postEnd - 1, positionMap);

		return root;
	}
}
