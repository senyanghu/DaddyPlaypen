package com.laioffer.hw03.queue_stack_linkedlist;

// when should we maintain the dummy head? 
// when we initially don't know which node will be the new
// head of a new linkedList. we can easily allocate a real memory for the dummy head.
// so we can APPEND the node to the dummy head

public class Q10_MergeTwoSortedList {
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
		return dummy.next;
	}
}
