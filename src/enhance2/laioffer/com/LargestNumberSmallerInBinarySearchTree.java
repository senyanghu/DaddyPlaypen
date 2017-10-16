package enhance2.laioffer.com;

// 在所有的比target小的node中 找个最大的 矮子里拔将军
public class LargestNumberSmallerInBinarySearchTree {
	public int largestSmaller(TreeNode root, int target) {
		int res = Integer.MIN_VALUE;
		while (root != null) {
			if (root.val < target) {
				target = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return res;
	}
}
