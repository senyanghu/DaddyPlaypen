package hw4.laioffer.com;

public class IsBalanced {
	// time complexity: 每个node都被访问一遍
	// O(n)
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	// time complexity: 画图算
	// 			root(n) 			getH(L) + getR(R) = O(n)
	// 			/  \
	// LChild(n/2) RChild(n/2)   				  = O(n)
	// .....
	// .....
	// there are Log(n) levels, so the total is O(nlogn)
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) > 0) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
}
