package hw03.queueStackLinkedlist.laioffer.com;

public class MiddleNode {
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
