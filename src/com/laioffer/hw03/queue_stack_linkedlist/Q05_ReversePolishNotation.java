package com.laioffer.hw03.queue_stack_linkedlist;

import java.util.*;

// a * (b + c) -> a b c + *
// 1 + 2 infix notation
// 1 2 + postfix notation
// infix -> postfix -> Shunting-yard algorithm
public class Q05_ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		int a, b;
		Stack<Integer> S = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) {
				S.add(S.pop() + S.pop());
			} else if (s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			} else if (s.equals("*")) {
				S.add(S.pop() * S.pop());
			} else if (s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			} else {
				S.add(Integer.parseInt(s));
			}
		}
		return S.pop();
	}
}
