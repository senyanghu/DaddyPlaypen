package hw7.dfs.laioffer.com;

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

	private void dfs(char[] arraySet, int index, List<String> res) {
		if (index == arraySet.length) {
			res.add(new String(arraySet));
			return;
		}
		for (int i = index; i < arraySet.length; i++) {
			swap(arraySet, index, i);
			dfs(arraySet, index + 1, res);
			swap(arraySet, i, index);
		}
	}

	private void swap(char[] arraySet, int i, int j) {
		char temp = arraySet[i];
		arraySet[i] = arraySet[j];
		arraySet[j] = temp;
	}
}
