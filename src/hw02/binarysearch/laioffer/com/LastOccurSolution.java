package hw02.binarysearch.laioffer.com;

public class LastOccurSolution {
	public int lastOccur(int[] array, int target) {
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
				start = mid + 1;
			} else if (array[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return res;
	}
	
	public static void main(String args[]) {
		LastOccurSolution los = new LastOccurSolution();
		int[] input = { 1, 2, 2, 2, 2, 2, 2, 3 };
		
		System.out.println(los.lastOccur(input, 3));
	}
}
