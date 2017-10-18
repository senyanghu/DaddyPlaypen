package hw03.queueStackLinkedlist.laioffer.com;

import java.util.*;

public class QueueUsingTwoStacks {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueUsingTwoStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void offer(int element) {
		stack1.add(element);
	}

	public Integer poll() {
		if (this.isEmpty()) {
			return null;
		} else {
			if (!stack2.isEmpty()) {
				return stack2.pop();
			} else {
				// stack2 is empty
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				return stack2.pop();
			}
		}
	}

	public Integer peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			if (!stack2.isEmpty()) {
				return stack2.peek();
			} else {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				return stack2.peek();
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
