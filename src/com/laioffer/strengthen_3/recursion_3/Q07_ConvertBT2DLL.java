package com.laioffer.strengthen_3.recursion_3;

public class Q07_ConvertBT2DLL {
	TreeNode head;
	static TreeNode prev = null;

	// A simple recursive function to convert a given Binary tree
	// to Doubly Linked List
	// root --> Root of Binary Tree
	void BinaryTree2DoubleLinkedList(TreeNode root) {
		// Base case
		if (root == null) {
			return;
		}

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);

		// Now convert this node
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}
}
