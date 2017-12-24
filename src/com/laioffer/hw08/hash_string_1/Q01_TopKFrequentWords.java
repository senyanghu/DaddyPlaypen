package com.laioffer.hw08.hash_string_1;

import java.util.*;

// view the hash table Wikipedia
// (1) separate chaining
// (2) open addressing - keep seeking the next available space

/**
 * For a composition with different kinds of words, try to find top k frequent
 * words from the composition
 */
// step1: iterate over the composition, and count each word and its frequency
// step2: use min-heap of size K to find the top k
class Pair {
	String str;
	int count;

	public Pair(String str, int count) {
		this.str = str;
		this.count = count;
	}
}

class PairComparator implements Comparator<Pair> {
	public int compare(Pair p1, Pair p2) {
		if (p1.count == p2.count) {
			return 0;
		} else if (p1.count < p2.count) {
			return -1;
		} else {
			return 1;
		}
	}
}

public class Q01_TopKFrequentWords {
	public String[] topK(String[] combo, int k) {
		Map<String, Integer> map = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new PairComparator());
		for (String str : combo) {
			map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Pair pair = new Pair(entry.getKey(), entry.getValue());
			pq.add(pair);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		String[] res = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = pq.poll().str;
		}
		return res;
	}

	public static void main(String args[]) {
		Q01_TopKFrequentWords topK = new Q01_TopKFrequentWords();
		String[] combo = { "Jessi", "Jessi", "Jessi", "Nick", "David", "Jon", "Jon" };
		String[] res = topK.topK(combo, 3);
		for (String str : res) {
			System.out.println(str);
		}
	}
}

// Follow up - If the data is extremely large
// Map Reduce
