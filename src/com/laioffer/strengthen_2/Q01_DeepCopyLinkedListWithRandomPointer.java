package com.laioffer.strengthen_2;

import java.util.*;

// 唯一的难点 建立origin和copy node的一一对应的关系 防止一个original node被重复copy一次以上
public class Q01_DeepCopyLinkedListWithRandomPointer {
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