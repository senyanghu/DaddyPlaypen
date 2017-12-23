package com.laioffer.hw07.graph_algo_2;

import java.util.*;

public class Q02_GenParentheses {
	public List<List<String>> generateVersion2(int n) {
		List<List<String>> res = new ArrayList<>();
		List<String> curSol = new ArrayList<>();
		dfsVersion2(curSol, n, n, res);
		return res;
	}

	private void dfsVersion2(List<String> cur, int left, int right, List<List<String>> res) {
		if (left == 0 && right == 0) {
			res.add(new ArrayList<String>(cur));
			System.out.println(cur.toString());
			return;
		}
		// case1: add the left ( to the current solution
		if (left > 0) {
			cur.add("(");
			dfsVersion2(cur, left - 1, right, res);
			cur.remove(cur.size() - 1);
		}
		// case2: add the right ) to the current solution
		if (right > left) {
			cur.add(")");
			dfsVersion2(cur, left, right - 1, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String args[]) {
		Q02_GenParentheses gp = new Q02_GenParentheses();
		for (List<String> subRes : gp.generateVersion2(3)) {
			System.out.println(subRes.toString());
		}
	}

	public List<String> generate(int n) {
		List<String> res = new ArrayList<>();
		char[] cur = new char[n * 2];
		dfs(cur, n, n, 0, res);
		return res;
	}

	private void dfs(char[] cur, int left, int right, int index, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(new String(cur));
			return;
		}
		if (left > 0) {
			cur[index] = '(';
			dfs(cur, left - 1, right, index + 1, res);
		}
		if (right > left) {
			cur[index] = ')';
			dfs(cur, left, right - 1, index + 1, res);
		}
	}
}
