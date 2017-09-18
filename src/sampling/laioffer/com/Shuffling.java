package sampling.laioffer.com;

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

public class Shuffling {
	List<Card> deck;

	public void shuffle() {

	}
}
