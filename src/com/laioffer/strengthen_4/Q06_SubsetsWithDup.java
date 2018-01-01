package com.laioffer.strengthen_4;

import java.util.*;

public class Q06_SubsetsWithDup {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		dfs_basic(nums, 0, item, result);

		return result;
	}

	private void dfs_basic(int[] nums, int index, List<Integer> item, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(item));
			return;
		}

		item.add(nums[index]);
		dfs_basic(nums, index + 1, item, result);
		item.remove(item.size() - 1);

		// skip all duplicate numbers
		while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
			index++;
		}

		dfs_basic(nums, index + 1, item, result);
	}
}
