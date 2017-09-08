package hw7.laioffer.com;

import java.util.*;

// assumption there is no duplications
public class Subsets {
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

		curSet = curSet.append(arraySet[index]);
		dfs(arraySet, curSet, index + 1, result);
		curSet.deleteCharAt(curSet.length() - 1);

		dfs(arraySet, curSet, index + 1, result);
	}

	public static void main(String args[]) {
		Subsets sf = new Subsets();

		String nums = "abc";
		List<String> res = sf.subsets(nums);
		for (String sub : res) {
			System.out.println(sub.toString());
		}

	}
}
