package enhance2.laioffer.com;

import java.util.*;

public class DeepCopyLinkedListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		// <original, clone>
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cursor = head;

		while (cursor != null) {
			map.put(cursor, new RandomListNode(cursor.value));
			cursor = cursor.next;
		}
		cursor = head;
		while (cursor != null) {
			map.get(cursor).random = map.get(cursor.random);
			cursor = cursor.next;
		}
		cursor = head;
		while (cursor != null) {
			map.get(cursor).next = map.get(cursor.next);
			cursor = cursor.next;
		}
		return map.get(head);
	}
}

class RandomListNode {
	public int value;
	public RandomListNode next;
	public RandomListNode random;

	public RandomListNode(int value) {
		this.value = value;
	}
}