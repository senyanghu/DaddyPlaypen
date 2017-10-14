package hw09.string.laioffer.com;

import java.util.*;

public class AllPermutationsWithDup {
	public List<String> permutations(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arrayChar = set.toCharArray();
		permutationsHelp(arrayChar, 0, res);
		return res;
	}

	private void permutationsHelp(char[] arrayChar, int index, List<String> res) {
		if (index == arrayChar.length) {
			res.add(new String(arrayChar));
			return;
		}
		Set<Character> usedSet = new HashSet<>();
		for (int i = index; i < arrayChar.length; i++) {
			if (usedSet.add(arrayChar[i])) {
				swap(arrayChar, index, i);
				permutationsHelp(arrayChar, index + 1, res);
				swap(arrayChar, index, i);
			}
		}
	}

	private void swap(char[] inputSet, int i, int j) {
		char temp = inputSet[i];
		inputSet[i] = inputSet[j];
		inputSet[j] = temp;
	}

	public static void main(String args[]) {
		String input = "aab";
		AllPermutationsWithDup apwd = new AllPermutationsWithDup();
		List<String> res = apwd.permutations(input);
		for (String sub : res) {
			System.out.println(sub);
		}
	}
}