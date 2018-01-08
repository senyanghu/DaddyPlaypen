package com.laioffer.strengthen_6;

import java.util.*;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.pollFirst();
			}

			deque.offerLast(i);

			if (i >= k - 1) {
				res[i + 1 - k] = nums[deque.peekFirst()];
			}
		}
		return res;
	}
}
