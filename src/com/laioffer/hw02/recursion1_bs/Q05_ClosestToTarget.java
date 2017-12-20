package com.laioffer.hw02.recursion1_bs;

// how to find an element in the sorted array which is closest to the target number
public class Q05_ClosestToTarget {
	public int closest(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		// 如果start + 1 == end 说明就剩下了两个元素 那么直接就进入了post processing
		// 现在是 <, 说明多于两个元素 所以就要慢慢算
		while (start + 1 < end) { // avoid infinite loop
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				start = mid; // WRONG!!! start = mid + 1 这种写法会把potential result给省略掉
			} else { // array[mid] > target
				end = mid; // WRONG!!! end = mid - 1 同理
			}
		}

		// post processing
		if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
			return start;
		} else {
			return end;
		}
	}
}
