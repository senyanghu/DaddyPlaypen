package com.laioffer.hw03.queue_stack_linkedlist;

import java.util.*;

// how could we implement a queue by using two stacks
// add() -- API -- Time = O(1)
// Remove() / Pop() -- API -- Time = O(n) -> Amortized Time O(1)
public class Q01_QueueUsingTwoStacks {
	// stack 1 is the only stock new elements when adding a new element into the
	// queue
	private Deque<Integer> stack1;
	// stack 2 is the only stack to pop elements out of the queue, when stack 2 is
	// empty, we move all data from stack 1 to stack 2
	private Deque<Integer> stack2;

	public Q01_QueueUsingTwoStacks() {
		stack1 = new LinkedList<>();
		stack2 = new LinkedList<>();
	}

	public void offer(int element) {
		stack1.offerFirst(element);
	}

	public Integer poll() {
		if (this.isEmpty()) {
			return null;
		} else {
			if (!stack2.isEmpty()) {
				return stack2.pollFirst();
			} else {
				// stack2 is empty
				while (!stack1.isEmpty()) {
					stack2.offerFirst(stack1.pollFirst());
				}
				return stack2.pollFirst();
			}
		}
	}

	public Integer peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			if (!stack2.isEmpty()) {
				return stack2.peekFirst();
			} else {
				while (!stack1.isEmpty()) {
					stack2.offerFirst(stack1.pollFirst());
				}
				return stack2.peekFirst();
			}
		}
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
