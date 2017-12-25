package com.laioffer.hw09.string_2;

// it is actually a sliding window problem, the window can contain at most K zeros in the window
public class Q10_Longest1WithFlip {
	public int longestSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int slow = 0;
		int longest = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] == 0) {
				if (k == 0) {
					while (k == 0) {
						longest = Math.max(longest, fast - slow + 1);
						if (nums[slow] == 0) {
							k++;
							slow++;
						} else {
							slow++;
						}
					}
				} else if (k > 0) {
					k--;
				}
			} else { // nums[fast] == 1
				longest = Math.max(longest, fast - slow + 1);
			}
		}

		return longest;
	}
}
