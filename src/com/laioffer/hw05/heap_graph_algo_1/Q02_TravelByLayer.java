package com.laioffer.hw05.heap_graph_algo_1;

import java.util.*;
import com.laioffer.hw04.bt_bst.TreeNode;

// typical BFS-1 algorithm
public class Q02_TravelByLayer {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size(); // 这是所有代码的核心
			List<Integer> curLayer = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(curLayer);
		}

		return res;
	}
}
