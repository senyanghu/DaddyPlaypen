package hw14.dp4.laioffer.com;

public class LargestSumOfSubarray {
	public int largest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int[] sum = new int[array.length];
		sum[0] = array[0];
		int max = sum[0];
		for (int i = 1; i < array.length; i++) {
			sum[i] = Integer.max(array[i], array[i] + sum[i - 1]);
			max = Integer.max(max, sum[i]);
		}
		return max;
	}

	public int largest2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int cur = array[0];
		int max = cur;
		for (int i = 1; i < array.length; i++) {
			cur = Integer.max(array[i], array[i] + cur);
			max = Integer.max(max, cur);
		}
		return max;
	}

	public int largest3(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int cur = array[0];
		int max = cur;

		int start = 0;
		int end = 0;
		int startRes = 0;
		int endRes = 0;

		for (int i = 1; i < array.length; i++) {
			if (cur < 0) {
				cur = array[i];
				start = i;
			} else {
				cur = array[i] + cur;
			}

			end = i;
			if (cur > max) {
				max = cur;
				startRes = start;
				endRes = end;
			}
		}
		System.out.println(startRes);
		System.out.println(endRes);
		return max;
	}
}
