package com.laioffer.strengthen_4;

import java.util.*;

public class Q04_SubsetsSumEqualToEachOther {
	public List<List<Integer>> subsets_sum_equal_to_each_other(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		dfs(nums, sum / 2, 0, item, result);

		return result;
	}

	private void dfs(int[] nums, int target, int index, List<Integer> item, List<List<Integer>> result) {
		if (index == nums.length) {
			if (target == 0) {
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}

		item.add(nums[index]);
		dfs(nums, target - nums[index], index + 1, item, result);
		item.remove(item.size() - 1);

		dfs(nums, target, index + 1, item, result);
	}

	public List<List<Integer>> subsets_basic(int[] nums) {
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

		dfs_basic(nums, index + 1, item, result);
	}

	public static void main(String args[]) {
		Q04_SubsetsSumEqualToEachOther sol = new Q04_SubsetsSumEqualToEachOther();
		int[] nums = { 1, 2 };
		for (List<Integer> sub : sol.subsets_basic(nums)) {
			System.out.println(sub.toString());
		}

		int[] numSet = { 1, 2, 3, 4 };
		for (List<Integer> sub : sol.subsets_sum_equal_to_each_other(numSet)) {
			System.out.println(sub.toString());
		}
	}
}
