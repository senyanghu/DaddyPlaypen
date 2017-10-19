package hw05.treeAndPQ.laioffer.com;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallest {
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
