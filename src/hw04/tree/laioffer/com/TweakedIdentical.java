package hw04.tree.laioffer.com;

// 照片八月十七日
// there are log2(n) levels
// Time Complexity: total nodes in this tree
// 4 ^ (log2(n)) = (2^2)^(log2(n)) = 2 ^ n
public class TweakedIdentical {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null || two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.val != two.val) {
			return false;
		}
		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
				|| isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
	}
}
