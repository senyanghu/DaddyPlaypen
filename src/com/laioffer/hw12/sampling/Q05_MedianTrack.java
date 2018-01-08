package com.laioffer.hw12.sampling;

import java.util.*;

/**
 * 5.Median Tracker Given an unlimited flow of numbers, keep track of the median
 * of all elements seen so far.
 * 
 * You will have to implement the following two methods for the class
 * 
 * read(int value) - read one value from the flow median() - return the median
 * at any time, return null if there is no value read so far Examples
 * 
 * read(1), median is 1
 * 
 * read(2), median is 1.5
 * 
 * read(3), median is 2
 * 
 * read(10), median is 2.5 ......
 * 
 * public class Solution { public Solution() { // add new fields and complete
 * the constructor if necessary. }
 * 
 * public void read(int value) { // write your implementation here. }
 * 
 * public Double median() { // write your implementation here. return null; } }
 */
public class Q05_MedianTrack {
	private PriorityQueue<Integer> largerHalf;
	private PriorityQueue<Integer> smallerHalf;

	public Q05_MedianTrack() {
		largerHalf = new PriorityQueue<>();
		smallerHalf = new PriorityQueue<>(Collections.reverseOrder());
	}

	public void read(int value) {
		// determine which heap to go
		if (smallerHalf.isEmpty() || smallerHalf.peek() >= value) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}

		// re-balance the load of two heaps
		if (smallerHalf.size() - largerHalf.size() >= 2) {
			largerHalf.offer(smallerHalf.poll());
		} else if (smallerHalf.size() < largerHalf.size()) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public Double median() {
		int size = smallerHalf.size() + largerHalf.size();
		if (size == 0) {
			return null;
		} else if (size % 2 == 1) {
			return (double) smallerHalf.peek();
		} else {
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}
}
