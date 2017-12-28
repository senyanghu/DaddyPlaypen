package com.laioffer.ood.black_jack;

public class Card {
	// 1 for A, 11 for J, 12 for Q, 13 for K, or we can use enum here
	private final int faceValue;
	private final Suit suit;

	public Card(int faceValue, Suit suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}

	public int value() {
		return this.faceValue;
	}

	public Suit suit() {
		return this.suit;
	}
}
