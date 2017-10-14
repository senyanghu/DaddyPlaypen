package hw05.laioffer.com;

import java.util.*;

class GraphNode {
	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<>();
	}
}

public class IsBipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		Map<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode gn : graph) {
			if (!BST(gn, visited)) {
				return false;
			}
		}
		return true;
	}

	private boolean BST(GraphNode gn, Map<GraphNode, Integer> visited) {
		if (visited.containsKey(gn)) {
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(gn);
		visited.put(gn, 0);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for (GraphNode nei : cur.neighbors) {
				if (!visited.containsKey(nei)) {
					queue.offer(nei);
					visited.put(nei, neiGroup);
				} else if (visited.get(nei) != neiGroup) {
					return false;
				}
			}
		}
		return true;
	}
}
