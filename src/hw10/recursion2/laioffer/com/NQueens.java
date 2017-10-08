package hw10.recursion2.laioffer.com;

import java.util.*;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two
 * Queens threaten each other.
 * 
 * Assumptions: N > 0
 * 
 * Return: A list of ways of putting the N Queens Each way is represented by a
 * list of the Queen's y index for x indices of 0 to (N - 1)
 * 
 * Example N = 4, there are two ways of putting 4 queens: [1, 3, 0, 2] --> the
 * Queen on the first row is at y index 1, the Queen on the second row is at y
 * index 3, the Queen on the third row is at y index 0 and the Queen on the
 * fourth row is at y index 2.
 *
 *
 */
public class NQueens {
	public List<List<Integer>> nqueen(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		List<Integer> sequence = new ArrayList<>();
		dfs(n, sequence, res);
		return res;
	}

	private void dfs(int n, List<Integer> sequence, List<List<Integer>> res) {
		if (sequence.size() == n) {
			res.add(new ArrayList<>(sequence));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(sequence, i)) {
				sequence.add(i);
				dfs(n, sequence, res);
				sequence.remove(sequence.size() - 1);
			}
		}
	}

	private boolean isValid(List<Integer> sequence, int value) {
		int size = sequence.size();
		for (int i = 0; i < size; i++) {
			if (sequence.get(i) == value || (size - i) == Math.abs(sequence.get(i) - value)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		NQueens nq = new NQueens();
		List<List<Integer>> res = nq.nqueen(4);
		for (List<Integer> subRes : res) {
			for (int col : subRes) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
