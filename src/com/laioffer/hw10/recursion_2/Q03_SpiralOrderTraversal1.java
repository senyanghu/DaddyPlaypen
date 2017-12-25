package com.laioffer.hw10.recursion_2;

import java.util.*;

/**
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top
 * left corner.
 * 
 * Return the list of traversal sequence. Assumptions The 2D array is not null
 * and has size of N * N where N >= 0
 * 
 * Examples { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} } the traversal sequence is [1, 2,
 * 3, 6, 9, 8, 7, 4, 5]
 *
 */
// 经典的剥洋葱的解法
// rotate the matrix by 90 degrees
public class Q03_SpiralOrderTraversal1 {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		spiralHelper(matrix, 0, matrix[0].length, res);
		return res;
	}

	/**
	 * @param matrix
	 * @param offset
	 *            偏移量
	 * @param size
	 * @param res
	 */
	private void spiralHelper(int[][] matrix, int offset, int size, List<Integer> res) {
		if (size == 0) {
			return;
		}

		if (size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		// top left to top right
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset][offset + i]);
		}

		// top right to bottom right
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset + i][offset + size - 1]);
		}

		// bottom right to bottom left
		for (int i = size - 1; i > 0; i--) {
			res.add(matrix[offset + size - 1][offset + i]);
		}

		// bottom left to top left
		for (int i = size - 1; i > 0; i--) {
			res.add(matrix[offset + i][offset]);
		}

		spiralHelper(matrix, offset + 1, size - 2, res);
	}

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Q03_SpiralOrderTraversal1 soto = new Q03_SpiralOrderTraversal1();
		List<Integer> res = soto.spiral(matrix);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
