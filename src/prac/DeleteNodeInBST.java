package prac;

import com.laioffer.hw04.bt_bst.TreeNode;

// 澳洲金老师尬聊课 BST三种遍历的非递归写法

// delete a node in BST
// case 1: the node to be deleted has no children
//        3
//      /   \
//     2     8

//    3
//  /   \
// 2

// case 2: the node to be deleted has no left child
//    3
//  /   \
// 2     8
//         \
//          10

//    3
//  /   \
// 2     10

// case 3: the node to be deleted has no right child
//     3
//   /   \
//  2     8
//       /
//      6

//     3
//   /   \
//  2     6

// case 4: the node to be deleted has both left and right child
//                 3
//               2   8
//                 6   10
//                4 7  9 12
// delete 8 -> 左子树的最大值 || 右子树的最小值

// case 4.1: the node to be deleted has both left and right child
//                 3
//               2   8
//                 6   10
//                       12

//                 3
//               2   10
//                 6   12

// case 4.2: the node to be deleted has both left and right child
//                 3
//               2   8
//                 6   10
//                    11  12
//                   9
//                    10

//                 3
//               2   9
//                 6   10
//                    11  12
//                   10

// leetcode 450
public class DeleteNodeInBST {
	public TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = delete(root.left, key);
		} else if (key > root.val) {
			root.right = delete(root.right, key);
		} else {
			// key == root.val
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// root has both left and right child
			TreeNode minNode = findMin(root.right, key);
			root.val = minNode.val;
			root.right = delete(root.right, root.val);
		}
		return root;
	}

	private TreeNode findMin(TreeNode root, int key) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
