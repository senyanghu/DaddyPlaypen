package com.laioffer.strengthen_2;

import java.util.*;

public class Q03_MergeKSortedArray {
	public int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new MyComparactor());
		
		int totalLength = 0;
		for (int i = 0; i < arrayOfArrays.length; i++) {
			int[] array = arrayOfArrays[i];
			totalLength += array.length;
			if (array.length != 0) {
				minHeap.offer(new Element(i, 0, array[0]));
			}
		}

		int[] result = new int[totalLength];
		int resultIndex = 0; // excluding, points to the next available spot
		
		while (!minHeap.isEmpty()) {
			Element temp = minHeap.poll();
			result[resultIndex++] = temp.value;

			if (temp.y + 1 < arrayOfArrays[temp.x].length) {
				temp.y++;
				temp.value = arrayOfArrays[temp.x][temp.y];
				minHeap.offer(temp);
			}
		}
		return result;
	}
	
	static class Element {
		int x;
		int y;
		int value;

		Element(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	static class MyComparactor implements Comparator<Element> {
		public int compare(Element e1, Element e2) {
			if (e1.value == e2.value) {
				return 0;
			}

			return e1.value < e2.value ? -1 : 1;
		}
	}
}
