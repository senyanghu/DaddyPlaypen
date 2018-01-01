package com.laioffer.strengthen_4;

import java.util.*;

public class Q05_SubsetsSizeEqualToK {

	public List<List<Integer>> subsets_basic(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		dfs_basic(nums, 0, k, item, result);

		return result;
	}

	private void dfs_basic(int[] nums, int index, int k, List<Integer> item, List<List<Integer>> result) {
		if (index == nums.length) {
			if (item.size() == k) {
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}

		item.add(nums[index]);
		dfs_basic(nums, index + 1, k, item, result);
		item.remove(item.size() - 1);

		dfs_basic(nums, index + 1, k, item, result);
	}

	public static void main(String args[]) {
		Q05_SubsetsSizeEqualToK sol = new Q05_SubsetsSizeEqualToK();
		int[] nums = { 1, 2 };
		for (List<Integer> sub : sol.subsets_basic(nums, 1)) {
			System.out.println(sub.toString());
		}
	}

}
