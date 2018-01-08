package com.laioffer.hw12.sampling;

import java.util.*;

enum Type {
	SPADES, HEARTS, DIAMONDS, CLUBS;
}

class Card {
	Type type;
	int value;
}

// (1) Random Shuffle = all the permutations has the same probability.
// (2) In all # of permutations = n!
// (3) Each of the permutation with probability of 1 / n!

public class Q01_Shuffling {
	List<Card> deck;

	public void shuffle(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		for (int i = array.length; i >= 1; i--) {
			int index = (int) (Math.random() * i);
			swap(array, index, i - 1);
		}
	}

	private void swap(int[] array, int index, int i) {
		int temp = array[index];
		array[index] = array[i];
		array[i] = temp;
	}

}
