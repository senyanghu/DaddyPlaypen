package com.laioffer.strengthen_1;

/**
 * Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
Assumptions

	* There is parent pointer for the nodes in the binary tree
	* The given two nodes are not guaranteed to be in the binary tree

Examples
        5
      /   \
     9     12
   /  \      \
  2    3      14
The lowest common ancestor of 2 and 14 is 5
The lowest common ancestor of 2 and 9 is 9
The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */

public class Q11_LowestCommonAncestor2 {
	public TreeNodeWithParent lca(TreeNodeWithParent nodeX, TreeNodeWithParent nodeY) {
		int nodeXLength = this.getLength(nodeX);
		int nodeYLength = this.getLength(nodeY);
		if (nodeXLength <= nodeYLength) {
			return meet(nodeX, nodeY, nodeYLength - nodeXLength);
		} else {
			return meet(nodeY, nodeX, nodeXLength - nodeYLength);
		}
	}
	
	public TreeNodeWithParent meet(TreeNodeWithParent shorter, TreeNodeWithParent longer, int diff) {
		while (diff != 0) {
			longer = longer.parent;
			diff --;
		}
		while (longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	
	public int getLength(TreeNodeWithParent node) {
		int length = 0;
		while (node != null) {
			length += 1;
			node = node.parent;
		}
		return length;
	}
}

class TreeNodeWithParent {
	public int key;
	public TreeNodeWithParent left;
	public TreeNodeWithParent right;
	public TreeNodeWithParent parent;
	public TreeNodeWithParent(int key, TreeNodeWithParent parent) {
		this.key = key;
		this.parent = parent;
	}
}
