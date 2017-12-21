package hw05.treeAndPQ.laioffer.com;

import java.util.*;

import com.laioffer.hw04.bt_bst.TreeNode;

public class IsTreeComplete {
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		boolean nonFullNodeSeen = false;

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur.left == null) {
				nonFullNodeSeen = true;
			} else if (nonFullNodeSeen) {
				// current node has left child and already meet the non-full node
				return false;
			} else {
				queue.offer(cur.left);
			}

			if (cur.right == null) {
				nonFullNodeSeen = true;
			} else if (nonFullNodeSeen) {
				// current node has right child and already meet the non-full node
				return false;
			} else {
				queue.offer(cur.right);
			}
		}

		return true;
	}
}
