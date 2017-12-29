package com.laioffer.strengthen_1;

import java.util.*;

// leetcode 109
public class Q10_BinaryTreeZigzagLevelOrderTraversal {
	public List<Integer> zigzag(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		int layer = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				if (layer == 0) {
					TreeNode temp = deque.pollLast();
					res.add(temp.key);
					if (temp.right != null) {
						deque.offerFirst(temp.right);
					}
					if (temp.left != null) {
						deque.offerFirst(temp.left);
					}
				} else {
					TreeNode temp = deque.pollFirst();
					res.add(temp.key); 
					if (temp.left != null) {
						deque.offerLast(temp.left);
					}
					if (temp.right != null) {
						deque.offerLast(temp.right);
					}
				}
			}
			layer = (layer == 0) ? 1 : 0;
		}
		return res;
	}
}

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}