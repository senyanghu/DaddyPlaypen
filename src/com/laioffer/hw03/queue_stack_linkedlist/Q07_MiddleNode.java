package com.laioffer.hw03.queue_stack_linkedlist;

// 一定要用这样的方式写 抓到的middle其实本质是前一半list的尾巴 可以轻而易举的拿到下一半的头
// O(n)
public class Q07_MiddleNode {
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode quick = head;
		while (quick.next != null && quick.next.next != null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		return slow;
	}
}
