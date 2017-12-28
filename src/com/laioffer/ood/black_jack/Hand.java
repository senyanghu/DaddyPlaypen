package com.laioffer.ood.black_jack;

import java.util.*;

public class Hand {
	protected final List<Card> cards = new ArrayList<>();

	public int score() {
		int score = 0;
		for (Card card : cards) {
			score += card.value();
		}
		return score;
	}

	public void addCards(Card[] c) {
		Collections.addAll(cards, c);
	}

	public int size() {
		return cards.size();
	}
}
