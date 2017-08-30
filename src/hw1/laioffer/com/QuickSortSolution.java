package hw1.laioffer.com;

public class QuickSortSolution {
	public int[] quickSort(int[] array) {
		// corner case
		if (array == null || array.length == 0) {
			return array;
		}
		quickSortHelper(array, 0, array.length - 1);
		return array;
	}

	private void quickSortHelper(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotPos = position(array, start, end);
		quickSortHelper(array, start, pivotPos - 1);
		quickSortHelper(array, pivotPos + 1, end);
	}

	private int position(int[] array, int start, int end) {
		int pivotIndex = this.pivotIndex(start, end);
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, end);
		int leftBound = start;
		int rightBound = end - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] > pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, end);
		return leftBound;
	}

	private int pivotIndex(int start, int end) {
		return start + (int) (Math.random() * (end - start + 1));
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String args[]) {
		QuickSortSolution qss = new QuickSortSolution();
		int[] input = { 1, 2, 10000, 2, 4, 6, 8, 99, 43, 1 };
		qss.quickSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}
}