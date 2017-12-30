package com.laioffer.strengthen_2;

import java.util.*;

/**
 * Merge K sorted lists into one big sorted list in ascending order. Assumptions
 * 
 * ListOfLists is not null, and none of the lists is null.
 */

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class MergeKSortedList {
	static class MyComparator implements Comparator<ListNode> {
		public int compare(ListNode l1, ListNode l2) {
			if (l1.value == l2.value) {
				return 0;
			}

			return l1.value < l2.value ? -1 : 1;
		}
	}

	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new MyComparator());
		
		ListNode dummy = new ListNode(0);
		ListNode curNode = dummy;
		
		for (ListNode node : listOfLists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}

		while (!minHeap.isEmpty()) {
			ListNode curMin = minHeap.poll();
			curNode.next = curMin;
			if (curMin.next != null) {
				minHeap.offer(curMin.next);
			}
			curNode = curNode.next;
		}
		return dummy.next;
	}

}
