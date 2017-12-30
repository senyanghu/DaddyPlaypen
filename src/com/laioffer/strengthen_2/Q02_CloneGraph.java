package com.laioffer.strengthen_2;

import java.util.*;

public class Q02_CloneGraph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	// solution 2 DFS - Recursion
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(cloneGraphDFS(neighbor));
		}
		return clone;
	}

	// solution 1
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); // new node
		Map<Integer, UndirectedGraphNode> map = new HashMap<>(); // store visited node
		map.put(newNode.label, newNode);

		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.pop();

			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor.label)) {
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				map.get(n.label).neighbors.add(map.get(neighbor.label));
			}
		}

		return newNode;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};