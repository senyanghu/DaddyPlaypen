package com.laioffer.strengthen_1;

import java.util.*;

/**
 * Use the least number of comparisons to get the largest and 2nd largest number
 * in the given integer array. Return the largest number and 2nd largest number.
 * Assumptions
 * 
 * The given array is not null and has length of at least 2
 * 
 * Examples
 * 
 * {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
 */
public class Q08_LargestAndSecondLargest_Not_Good {
	static class Element {
		int value;
		List<Integer> comparedValues;

		Element(int value) {
			this.value = value;
			this.comparedValues = new ArrayList<Integer>();
		}
	}

	private Element[] convert(int[] array) {
		Element[] helper = new Element[array.length];
		for (int i = 0; i < array.length; i++) {
			helper[i] = new Element(array[i]);
		}
		return helper;
	}

	private int largest(List<Integer> list) {
		int max = list.get(0);
		for (int i : list) {
			max = Math.max(max, i);
		}
		return max;
	}

	private void compareAndSwap(Element[] array, int length) {
		for (int i = 0; i < length / 2; i++) {
			if (array[i].value < array[length - i - 1].value) {
				swap(array, i, length - i - 1);
			}
			array[i].comparedValues.add(array[length - i - 1].value);
		}
	}

	private void swap(Element[] array, int i, int j) {
		Element temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int[] largestAndSecond(int[] array) {
		if (array == null) {
			return null;
		}

		Element[] helperArray = convert(array);
		int length = array.length;
		while (length > 1) {
			compareAndSwap(helperArray, length);
			length = (length + 1) / 2;
		}
		return new int[] { helperArray[0].value, largest(helperArray[0].comparedValues) };
	}
}
