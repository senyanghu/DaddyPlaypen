package com.laioffer.hw10.recursion_2;

/**
 * Reverse pairs of elements in a singly-linked list.
 * 
 * Examples
 * 
 * L = null, after reverse is null
 * 
 * L = 1 -> null, after reverse is 1 -> null
 * 
 * L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null L = 1 -> 2 -> 3 -> null,
 * after reverse is 2 -> 1 -> 3 -> null
 */
// time = O(n)
// space = O(n)
public class Q04_ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode subHead = reverseInPairs(head.next.next);
		ListNode newHead = head.next;
		newHead.next = head;
		head.next = subHead;
		return newHead;
	}

}
