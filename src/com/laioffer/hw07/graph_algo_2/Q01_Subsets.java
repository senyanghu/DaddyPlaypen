package com.laioffer.hw07.graph_algo_2;

import java.util.*;

// assumption there is no duplications
public class Q01_Subsets {
	public List<String> subsets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}

		StringBuilder curSet = new StringBuilder();
		char[] arraySet = set.toCharArray();
		dfs(arraySet, curSet, 0, result);
		return result;
	}

	private void dfs(char[] arraySet, StringBuilder curSet, int index, List<String> result) {
		if (index == arraySet.length) {
			result.add(curSet.toString());
			return;
		}
		/*
		dfs(arraySet, curSet, index + 1, result);

		curSet = curSet.append(arraySet[index]);
		dfs(arraySet, curSet, index + 1, result);
		curSet.deleteCharAt(curSet.length() - 1);
		*/
		for (int i = 0; i < 2; i++) { // 每层有两个状态
			if (i == 0) { // 状态1
				curSet = curSet.append(arraySet[index]);
				dfs(arraySet, curSet, index + 1, result);
				curSet.deleteCharAt(curSet.length() - 1);
			} else { // 状态2
				// curSet.append(NOTHING);
				dfs(arraySet, curSet, index + 1, result);
				// curSet.deleteCharAt(NOTHING)
			}
		}
	}

	public static void main(String args[]) {
		Q01_Subsets sf = new Q01_Subsets();

		String nums = "ab";
		List<String> res = sf.subsets(nums);
		for (String sub : res) {
			System.out.println(sub.toString());
		}
	}
}
