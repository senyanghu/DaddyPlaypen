package enhance1.laioffer.com;

/**
 * 
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array need to be
 * maintained. Assumptions:
 * 
 * The given array is not null.
 * 
 * Examples:
 * 
 * {1} --> {1} 
 * 
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */
public class Move0ToTheEnd2 {
	public int[] moveZero(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int resIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[resIndex++] = array[i];
			}
		}
		while (resIndex < array.length) {
			array[resIndex++] = 0;
		}
		return array;
	}
}
