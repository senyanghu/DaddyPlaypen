package com.laioffer.hw03.queue_stack_linkedlist;

public class Q06_ReverseLinkedList {
	public ListNode reverseIterative(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;

		while (cur != null) {
			next = head.next; // store the new head of sub-list
			cur.next = prev; // reverse happens here
			prev = cur; // move prev by 1 step
			cur = next; // move cur by 1 step
		}

		return prev;
	}

	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head; // base case
		}

		ListNode newHead = reverseRecursively(head.next); // newHead = N1000
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}
