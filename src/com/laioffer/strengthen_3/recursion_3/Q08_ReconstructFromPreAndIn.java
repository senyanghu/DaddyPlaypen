package com.laioffer.strengthen_3.recursion_3;

import java.util.*;

public class Q08_ReconstructFromPreAndIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLength = preorder.length;
		int inLength = inorder.length;
		Map<Integer, Integer> positionHash = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			positionHash.put(inorder[i], i);
		}
		return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1, positionHash);
	}

	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> positionHash) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndex = positionHash.get(root.key);

		int len = rootIndex - inStart; // left number length
		root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1, positionHash);
		root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd, positionHash);
		return root;
	}
}
