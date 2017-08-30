package hw4.laioffer.com;

public class IsSymmetric {
	// time complexity is O(n)
	// space = O(height of recursion tree) = O(n/2) = O(n) worst case是一条直线
	// https://leetcode.com/articles/symmetric-tree/
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
