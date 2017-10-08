package hw10.recursion2.laioffer.com;

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
}

public class LowestCommonAncestor {
	public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return root;
		}
		if (root == one || root == two) {
			return root;
		}
		TreeNode left = lca(root.left, one, two);
		TreeNode right = lca(root.right, one, two);

		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else {
			return left;
		}
	}
}
