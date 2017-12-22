package com.laioffer.hw05.heap_graph_algo_1;

import java.util.*;

// find the smallest K elements from an unsorted array of size n
// assumption: n is reasonably large, its data ranges [1, 1000] integers
// method 1: sort them and return first K elements
// see the notes
public class Q01_KSmallest {
	public int[] KSmallestNumber(int[] array, int k) {
		if (array == null || array.length == 0 || k >= array.length) {
			return array;
		}
		if (k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int element : array) {
			pq.offer(element);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = pq.poll();
		}
		return res;
	}
}
