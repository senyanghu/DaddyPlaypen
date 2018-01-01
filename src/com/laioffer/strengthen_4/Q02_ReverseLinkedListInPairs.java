package com.laioffer.strengthen_4;

import com.laioffer.hw10.recursion_2.ListNode;

public class Q02_ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = head.next;
		ListNode subHead = reverseInPairs(head.next.next);
		newHead.next = head;
		head.next = subHead;
		return newHead;
	}
}
