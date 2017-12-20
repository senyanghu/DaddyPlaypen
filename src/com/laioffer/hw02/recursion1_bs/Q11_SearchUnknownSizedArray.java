package com.laioffer.hw02.recursion1_bs;

abstract class Dictionary {
	public Integer get(int index) {
		return 0;
	}
}

// step 1: keep jumping out from 0th index at the step size until we jump out of
// the dictionary
// step 2: run a classical binary search

// 两倍两倍跳 也可以 十倍十倍跳
// follow up: what if we jump out at the pace of 10*i instead of 2*i
// 2 times:
// jump out: log_2(n) ------ jump in: log_2(2n)
// 10 times:
// jump out: log_10(n) ------ jump in: log_2(10n)
// 把两个加起来的和再相减 然后分析结果
// 10 times is better
public class Q11_SearchUnknownSizedArray {
	public int search(Dictionary dict, int target) {
		if (dict == null) {
			return -1;
		}

		int start = 0;
		int end = 1;

		while (dict.get(end) != null && dict.get(end) < target) {
			start = end;
			end = end * 2;
		}

		return binarySearch(dict, target, start, end);
	}

	private int binarySearch(Dictionary dict, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (dict.get(mid) == null || dict.get(mid) < target) {
				end = end - 1;
			} else if (dict.get(mid) > target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
