package hw2.laioffer.com;

abstract class Dictionary {
	public Integer get(int index) {
		return 0;
	}
}

public class SearchUnknownSizedArraySolution {
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
