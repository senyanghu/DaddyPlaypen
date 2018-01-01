package com.laioffer.strengthen_4;

import com.laioffer.hw03.queue_stack_linkedlist.ListNode;

public class Q01_ReverseLinkedList {
	public ListNode reverseIterative(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}
		return prev;
	}

	public ListNode reverseRecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode next = head.next;
		ListNode subListHead = reverseRecursive(next);
		head.next = prev;
		next.next = head;
		return subListHead;

		// ListNode newHead = reverseRecursively(head.next); // newHead = N1000
		// head.next.next = head;
		// head.next = null;
		// return newHead;
	}
}
