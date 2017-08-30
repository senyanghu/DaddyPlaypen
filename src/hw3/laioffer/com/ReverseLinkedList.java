package hw3.laioffer.com;

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
}
