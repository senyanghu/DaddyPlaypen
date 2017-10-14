package enhance1.laioffer.com;

public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			if (array[i] < array[n - 1 - i]) {
				swap(array, i, n - 1 - i);
			}
		}
		int largestElement = largest(array, 0, (n - 1) / 2);
		int smallestElement = smallest(array, n / 2, n - 1);
		return new int[] { largestElement, smallestElement };
	}

	private int largest(int[] array, int left, int right) {
		int largest = array[left];
		for (int i = left + 1; i <= right; i++) {
			largest = Math.max(largest, array[i]);
		}

		return largest;
	}

	private int smallest(int[] array, int left, int right) {
		int smallest = array[left];
		for (int i = left + 1; i <= right; i++) {
			smallest = Math.min(smallest, array[i]);
		}

		return smallest;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
