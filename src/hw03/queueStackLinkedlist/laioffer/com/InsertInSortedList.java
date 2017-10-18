package hw03.queueStackLinkedlist.laioffer.com;

public class InsertInSortedList {
	public ListNode insert(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		if (head == null || head.val >= val) {
			newNode.next = head;
			return newNode;
		}

		ListNode cur = head;
		while (cur.next != null && cur.next.val < val) {
			cur = cur.next;
		}
		newNode.next = cur.next;
		cur.next = newNode;
		return head;
	}
}
