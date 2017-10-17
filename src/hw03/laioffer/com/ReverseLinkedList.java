package hw03.laioffer.com;

public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = head.next;
		ListNode newHead = reverseRecursively(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}

}
