package com.laioffer.hw03.queue_stack_linkedlist;

public class Q09_InsertInSortedList {
	public ListNode insert(ListNode head, int target) {
		ListNode newNode = new ListNode(target);

		if (head == null) {
			return newNode;
		}

		if (head.val >= target) {
			newNode.next = head;
			return newNode;
		}

		ListNode cur = head;
		while (cur.next != null && cur.next.val < target) {
			cur = cur.next;
		}
		newNode.next = cur.next;
		cur.next = newNode;
		return head;
	}
}
