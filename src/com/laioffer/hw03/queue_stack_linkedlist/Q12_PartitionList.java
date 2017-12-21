package com.laioffer.hw03.queue_stack_linkedlist;

// in my iPhone
public class Q12_PartitionList {
	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode curSmall = dummySmall;
		ListNode curLarge = dummyLarge;
		ListNode cur = head;

		while (cur != null) {
			if (cur.val < target) {
				curSmall.next = cur;
				curSmall = curSmall.next;
			} else {
				curLarge.next = cur;
				curLarge = curLarge.next;
			}
			cur = cur.next;
		}
		curSmall.next = dummyLarge.next;
		curLarge.next = null; // this step is very important, we need to set the large list's next to NULL,
								// otherwise the circle will be created
		return dummySmall.next;
	}
}
