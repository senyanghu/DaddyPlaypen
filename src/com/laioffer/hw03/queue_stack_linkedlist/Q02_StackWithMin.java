package com.laioffer.hw03.queue_stack_linkedlist;

import java.util.*;

// how to implement the min() function when using stack with time complexity O(1)
// stack 1: 3 1 -7 -6
// stack 2: 3 1 -7 -7
// O(1) - time
// O(n) - space

// follow up: assume there are lots of duplicates elements in the input
// stack 1: 111111 -1 111 3 44444444444444
// stack 2: <1, 1>, <-1, 7> 只需要一直记录单调递减的元素 <x, ?> ?用于记录x第一次出现的时候 stack里面元素的个数
// add ????
// delete ????
// systematic way of thinking:
// rule 1: try to make the elements in stack 2 descending order and store an element in stack 2 in the 
// format of <value, size of stack1 when this element is added to stack2 for the first time>
public class Q02_StackWithMin {
	// this is used to record the data
	private Deque<Integer> stack1;
	// this is used to record the minimum integers
	private Deque<Integer> stack2;

	public Q02_StackWithMin() {
		this.stack1 = new LinkedList<>();
		this.stack2 = new LinkedList<>();
	}

	public void push(int element) {
		stack1.offerFirst(element);
		if (stack2.isEmpty()) {
			stack2.offerFirst(element);
		} else {
			int curMin = stack2.peekFirst();
			if (curMin > element) { // 说明curMin我们不能要 要淘汰
				stack2.offerFirst(element);
			} else {
				stack2.offerFirst(curMin);
			}
		}
	}

	public int pop() {
		if (stack1.isEmpty()) {
			return -1;
		}
		stack2.pollFirst();
		return stack1.pollFirst();
	}

	public int top() {
		if (stack1.isEmpty()) {
			return -1;
		}
		return stack1.peekFirst();
	}

	public int min() {
		if (stack1.isEmpty()) {
			return -1;
		}
		return stack2.peekFirst();
	}
}
