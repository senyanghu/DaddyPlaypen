package hw03.queueStackLinkedlist.laioffer.com;

import java.util.*;

public class StackWithMin {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2; // this is used to record the minimum integers

	public StackWithMin() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
	
	public void push(int element) {
		stack1.push(element);
		if (stack2.isEmpty()) {
			stack2.push(element);
		} else {
			int curMin = stack2.peek();
			if (curMin > element) {
				stack2.push(element);
			} else {
				stack2.push(curMin);
			}
		}
	}
	
	public int pop() {
		if (stack1.isEmpty()) {
			return -1;
		}
		stack2.pop();
		return stack1.pop();
	}
	
	public int top() {
		if (stack1.isEmpty()) {
			return -1;
		}
		return stack1.peek();
	}
	
	public int min() {
		if (stack1.isEmpty()) {
			return -1;
		}
		return stack2.peek();
	}
}
