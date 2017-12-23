package com.laioffer.hw07.graph_algo_2;

import java.util.*;

// no duplications
public class Q04_AllPermutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	// index is the level that we are trying
	public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int index) {
		if (index == nums.length) {
			res.add(new ArrayList<Integer>(tempList));
			System.out.println(res);
			return;
		}

		// explore all the states in each level
		// index represents the level
		// each level, there are different states
		for (int i = index; i < nums.length; i++) {
			swapInt(nums, index, i);
			tempList.add(nums[index]);
			backtrack(res, tempList, nums, index + 1);
			tempList.remove(tempList.size() - 1);
			swapInt(nums, index, i);
		}
	}

	private void swapInt(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[]) {
		Q04_AllPermutations sol = new Q04_AllPermutations();
		int[] nums = { 1, 2, 3 };
		sol.permute(nums);
	}

	public List<String> permutations(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arraySet = set.toCharArray();
		dfs(arraySet, 0, res);
		return res;
	}

	private void dfs(char[] arraySet, int start, List<String> res) {
		if (start == arraySet.length) {
			res.add(new String(arraySet));
			return;
		}
		for (int i = start; i < arraySet.length; i++) {
			swap(arraySet, start, i);
			dfs(arraySet, start + 1, res);
			swap(arraySet, i, start);
		}
	}

	private void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
}
