package enhance2.laioffer.com;

import java.util.*;

public class CloneGraph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(cloneGraph(neighbor));
		}
		return clone;
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