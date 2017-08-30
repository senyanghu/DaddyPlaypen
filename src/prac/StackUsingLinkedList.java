package prac;
class ListNode {
	public Object obj;
	public ListNode next;

	public ListNode(Object obj) {
		this.obj = obj;
		this.next = null;
	}
}

public class StackUsingLinkedList {
	private ListNode head;
	private int length;

	public StackUsingLinkedList() {
		this.head = null;
		this.length = 0;
	}

	public void push(Object element) {
		ListNode newNode = new ListNode(element);
		newNode.next = head;
		head = newNode;
		this.length++;
	}

	public Object pop() {
		if (this.length == 0) {
			return null;
		} else {
			Object obj = head.obj;
			head = head.next;
			this.length--;
			return obj;
		}
	}

	public Object peek() {
		if (head == null) {
			return null;
		} else {
			return head.obj;
		}
	}
}
