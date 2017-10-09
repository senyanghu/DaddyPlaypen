package hw7.dfs.laioffer.com;

import java.util.*;

public class GenParentheses {
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
		if (left > right) {
			cur[index] = ')';
			dfs(cur, left, right - 1, index + 1, res);
		}
	}
}
