package hw07.dfs.laioffer.com;

import java.util.*;

public class AllPermutations {
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

	private void swap(char[] arraySet, int i, int j) {
		char temp = arraySet[i];
		arraySet[i] = arraySet[j];
		arraySet[j] = temp;
	}
}
