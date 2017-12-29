package com.laioffer.strengthen_1;

public class EnhancedPracticeOne {
	/**
	 * Element de-duplications/removal in an array 基本思想 两个变量 一个记录当前位置 另一个记录当前挡板
	 * 
	 * slow(including) and left
	 */
	public int removeDup(int[] input) {
		int slow = 0;
		for (int fast = 1; fast < input.length; fast++) {
			if (input[fast] == input[slow]) {
				continue;
			}
			input[++slow] = input[fast];
		}
		return slow + 1;
	}

	public int removeDupAtLeastTwo(int[] input) {
		int slow = 1;
		for (int fast = 2; fast < input.length; fast++) {
			if (input[fast] == input[slow - 1]) {
				continue;
			}
			input[++slow] = input[fast];
		}
		return slow + 1;
	}

	public int removeDupAtLeastK(int[] input, int k) {
		int slow = k - 1;
		for (int fast = k; fast < input.length; fast++) {
			if (input[fast] == input[slow - k + 1]) {
				continue;
			}
			input[++slow] = input[fast];
		}
		return slow + 1;
	}

	/**
	 * 对于重复元素 一个都不保留 input 1 1 2 3 3 output 2 slow(ex-cluding) fast1 fast2
	 */
	public int removeAnyDup(int[] input) {
		int slow = 0;
		int fast = 0;
		while (fast < input.length) {
			int begin = fast;
			while (fast < input.length && input[fast] == input[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				input[slow++] = input[begin];
			}
		}
		return slow;
	}

	/**
	 * Question 1.5.1 再问一下zhubingbing
	 * 挤0 
	 * 1 9 8 4 0 0 2 7 
	 * 1 9 8 4 2 7 0 0
	 *
	 * left (excluding): non-zeros 
	 * right (excluding): zeros 
	 * [left, right]: 等待探索
	 */
	public int test(int[] input) {
		int left = 0;
		int right = input.length - 1;
		while (left <= right) {
			if (input[left] != 0) {
				left++;
			} else if (input[right] == 0) {
				right--;
			} else {
				swap(input, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] input, int left, int right) {
		int leftValue = input[left];
		input[left] = input[right];
		input[right] = leftValue;
	}
	
	/**
	 * 智力题
	 * Use the least number of comparisons to find the largest and smallest number
	 */
	
	/**
	 * 剥洋葱
	 * Spiral
	 */
	
	/**
	 * LCA 1, 2 (up pointer), 3
	 * 有很多条LCA 回头让bingbing贴上来
	 * K Node LCA
	 * 5.1 - 5.6
	 */
	/**
	 * LCA for two nodes a and b in a very large tree that contains billions of nodes
	 * map: 1 job -> distribute 32 machines
	 * reducer: collect results from each of the 32 machines to do some aggregation
	 * 
	 * case 1: both nodes a and b are within the top 5 layers (we can run BFS1 with top 5 layers)
	 *  call LCA(root, a, b, level_limit = 5)
	 * 
	 * case 2: either a or b is within top 5 layers (a is in, b is not)
	 * call find(M1, b), Find(M2, b) .... Find(M32, b) => say M7 found b
	 * call LCA(root, a, M7, level_limit = 5)
	 * 
	 * 看我的手机里面的照片
	 */
	
}
