package hw05.treeAndPQ.laioffer.com;

import java.util.*;

import hw04.tree.laioffer.com.TreeNode;

public class TravelByLayer {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
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
