package com.laioffer.hw05.heap_graph_algo_1;

import java.util.*;

public class Q05_KSmallestInMatrix {
	private class Cell {
		int row, col, val;

		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public int KthSmallest(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];

		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? -1 : 1;
			}
		});

		pq.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;

		for (int i = 0; i < k - 1; i++) {
			Cell cur = pq.poll();
			if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
				pq.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visited[cur.row + 1][cur.col] = true;
			}
			if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
				pq.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visited[cur.row][cur.col + 1] = true;
			}
		}

		return pq.peek().val;
	}
}
