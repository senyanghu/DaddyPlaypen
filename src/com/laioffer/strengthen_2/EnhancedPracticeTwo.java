package com.laioffer.strengthen_2;

import java.util.*;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
	}
}

public class EnhancedPracticeTwo {
	// deep copy linked list with random pointer
	public Node deepCopyLinkedListWithTandomPointer(Node head) {
		if (head == null) {
			return null;
		}
		Map<Node, Node> lookup = new HashMap<>();
		Node newHead = new Node(head.val);
		Node cur = head;

		while (head != null) {
			if (head.next != null) {
				if (!lookup.containsKey(head.next)) {
					lookup.put(head.next, new Node(head.next.val));
				}
				cur.next = lookup.get(head.next);
			}
			if (head.random != null) {
				if (!lookup.containsKey(head.random)) {
					lookup.put(head.random, new Node(head.random.val));
				}
				cur.random = lookup.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}

	class Vertex {
		int val;
		List<Vertex> neighbors;

		public Vertex(int val) {
			this.val = val;
		}
	}

	// deep copy graph --- DFS
	// build a hash map to avoid duplication when copying a node
	public Vertex cloneGraph(Vertex input, Map<Vertex, Vertex> lookup) {
		if (input == null) {
			return null;
		}
		if (lookup.containsKey(input)) {
			return lookup.get(input);
		}
		Vertex copyVertex = new Vertex(input.val);

		lookup.put(input, copyVertex);
		for (Vertex neighbor : input.neighbors) {
			copyVertex.neighbors.add(cloneGraph(neighbor, lookup)); // 这种写法是课程里第一次见到 值得学习
		}
		return copyVertex;
	}

	// How to merge K sorted arrays into one big sorted array
	// Assumptions:
	// -length
	// -ascending / descending
	// -data type
	// fit in memory
	// solution 1: K pointers all together
	// Use a Heap to store K pointers, so we can find the smallest one in O(1) time
	// 有k行 每行平均n个元素
	// O(nk * log(k))
	// space O(k)

	// solution 2:
	// Binary Reduction:
	// A1 A2 -> A12
	// A3 A4 -> A34 -> A14
	// A5 A6 -> A56
	// A7 A8 -> A78 -> A58 -> A18
	// kn kn kn....
	// log(k) * kn
	// space (nk) 虽然有log(k)层 每一层的O(nk) 但是用完了就可以丢弃 相当于始终保持了一层的数据 所以是O(nk)

	// solution 1 读写磁盘的次数会比 solution 2的次数少很多 IO的这个问题需要考虑
	public void mergeK(List<Integer> lists) {

	}

	// how to remove a target value from BST
	// case 1: if target > root, root.right = delete(root.right, target)
	// case 2: if target < root, root.left = delete(root.left, target)
	// case 3: if target == root
	// 3.1: if root is a leaf, return null
	// 3.2: if root has only one child, return this child
	// 3.3: if root has two children
	// step 1: find the node with largest value in the left subtree
	// step 2: copy过来
	// step 3: 再recursion做 见照片 Oct 1

	
	
	// how to insert a target node in a BST

	
	// DP中心开花
	
}
