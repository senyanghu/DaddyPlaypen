package com.laioffer.strengthen_3.recursion_3;

import java.util.*;

// O(n^2) - Time - Space
public class Q10_ReconstructFromInOrderAndLevelOrder {

	public TreeNode reconstruct(int[] in, int[] level) {
		// Write your solution here.
		Map<Integer, Integer> indexMap = getIndexMap(in);
		List<Integer> levelList = getlevelList(level);
		return reconstructHelper(indexMap, levelList);
	}

	private TreeNode reconstructHelper(Map<Integer, Integer> indexMap, List<Integer> levelList) {
		if (levelList.isEmpty()) {
			return null;
		}

		TreeNode root = new TreeNode(levelList.remove(0));
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();

		for (int num : levelList) {
			if (indexMap.get(num) < indexMap.get(root.key)) {
				leftList.add(num);
			} else {
				rightList.add(num);
			}
		}

		root.left = reconstructHelper(indexMap, leftList);
		root.right = reconstructHelper(indexMap, rightList);

		return root;
	}

	private Map<Integer, Integer> getIndexMap(int[] in) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			indexMap.put(in[i], i);
		}
		return indexMap;
	}

	private List<Integer> getlevelList(int[] level) {
		List<Integer> result = new ArrayList<>();
		for (int num : level) {
			result.add(num);
		}
		return result;
	}

}
