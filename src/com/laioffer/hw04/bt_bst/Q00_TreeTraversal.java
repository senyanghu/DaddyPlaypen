package com.laioffer.hw04.bt_bst;

import java.util.*;

// trick: base case 永远是空指针null (99%的情况都是这样）
public class Q00_TreeTraversal {
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public List<Integer> preOrderInterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();

		if (root == null) {
			return res;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	public List<Integer> inOrderIterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		TreeNode cur = root;
		Deque<TreeNode> stack = new LinkedList<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}

	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val);
	}

	public List<Integer> postOrderIterative(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		List<Integer> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);

			if (node.left != null) {
				stack.push(node.left);
			}

			if (node.right != null) {
				stack.push(node.right);
			}
		}

		Collections.reverse(res);
		return res;
	}
}
