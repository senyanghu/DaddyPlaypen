package enhance2.laioffer.com;

/**
 * Insert a key in a binary search tree if the binary search tree does not
 * already contain the key. Return the root of the binary search tree.
 * Assumptions
 * 
 * There are no duplicate keys in the binary search tree
 * 
 * If the key is already existed in the binary search tree, you do not need to
 * do anything
 */
public class InsertInBinarySearchTree {
	public TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}

		TreeNode parent = null;
		TreeNode curNode = root;
		TreeNode insertNode = new TreeNode(val);

		while (curNode != null) {
			parent = curNode;
			if (val > curNode.val) {
				curNode = curNode.right;
			} else if (val < curNode.val) {
				curNode = curNode.left;
			} else {
				return root;
			}
		}

		if (parent.val > val) {
			parent.left = insertNode;
		} else if (parent.val < val) {
			parent.right = insertNode;
		}

		return root;
	}
}
