package hw02.binarysearch.laioffer.com;

// binary search 两大诀窍
// (1) 每一次要把问题的scope narrow down
// (2) 在每一轮的迭代不能把potential result给放过去
public class FirstOccurSolution {
	public int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;

		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				res = mid;
				end = mid - 1;
			} else if (array[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		FirstOccurSolution fos = new FirstOccurSolution();
		int[] input = { 1, 2, 2, 2, 3 };
		System.out.println(fos.firstOccur(input, 2));
	}
}
