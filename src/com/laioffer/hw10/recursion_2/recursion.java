package com.laioffer.hw10.recursion_2;

// algorithm note - Sept 03
// class 11 - recursion - second class
// boil down a big problem to smaller ones (size n depends on size n-1, n-2 or ... n/2)

public class recursion {
	// recursion与计算的结合
	// a^b
	// 0^0
	// denominator == 0
	// data type convertion (accuracy loss) int - double
	public double myPow(double x, int n) {
		if (x == 0 && n == 0) {
			System.out.println("ERROR");
		} else if (x == 0) {
			return 0;
		}
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	public double power(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double v = power(x, n / 2);

		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}

	// 八王后
	// eight queen
	// 一共分为八层
	// L1 Q0 can be put to [0][0], [0][1] ... [0][7]
	// L2 Q1 can be put to [1][0], ......
	// L3
	// L4
	// Total Time = O(n!)

	// how to print 2D array in spiral order (N * N)
	// 这条题目还可以用recursion做 amazing
	// feature1: size -= 2
	// feature2: shift += 1
	// offset - 偏移量

	// reverse a linked list (pair to pair)
	public ListNode reversePairToPair(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node2 = head.next;
		ListNode newHead = reversePairToPair(head.next.next);
		head.next.next = head;
		head.next = newHead;
		return node2;
	}

	// Lowest Common Ancestor (LCA) - 这个问题今天讲的很深

	// Given a very big tree with 1 trillion nodes, and 1000 machines, how can we
	// get the solution in parallel?
	
	
	// 太困了 手机拍下来了 follow up 1
	// follow up 2
}
