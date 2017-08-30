package hw3.laioffer.com;

// in my iPhone
public class PartitionList {
	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode curSmall = dummySmall;
		ListNode curLarge = dummyLarge;

		while (head != null) {
			if (head.val < target) {
				curSmall.next = head;
				curSmall = curSmall.next;
			} else {
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		curSmall.next = dummyLarge.next;
		curLarge.next = null;
		return dummySmall.next;
	}
}
