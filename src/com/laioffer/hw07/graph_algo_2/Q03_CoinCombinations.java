package com.laioffer.hw07.graph_algo_2;

import java.util.*;

public class Q03_CoinCombinations {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		dfs(target, coins, res, cur, 0);
		return res;
	}

	private void dfs(int target, int[] coins, List<List<Integer>> res, List<Integer> cur, int index) {
		if (index == coins.length) {
			if (target == 0) {
				res.add(new ArrayList<Integer>(cur));
			}
			return;
		}

		int limit = target / coins[index];

		for (int i = 0; i <= limit; i++) {
			cur.add(i);
			dfs(target - i * coins[index], coins, res, cur, index + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String args[]) {
		Q03_CoinCombinations cc = new Q03_CoinCombinations();
		int CB_1100 = 13200;
		int[] coins = { 100, 900 };
		List<List<Integer>> res = cc.combinations(CB_1100, coins);

		for (List<Integer> sub : res) {
			System.out.println(sub.toString());
		}
		System.out.println("END");
	}
}
