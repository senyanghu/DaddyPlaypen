package com.laioffer.ood.black_jack;

import java.util.*;

public class BlackJackGameAutomator {
	private Deck deck;
	private BlackJackHand[] players;
	private final static int HIT_UNTIL = 16;

	public BlackJackGameAutomator(int numPlayers) {
		players = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new BlackJackHand();
		}
	}

	void initializeDeck() {
		deck = new Deck();
		deck.shuffle();
	}

	boolean dealInitial() {
		for (BlackJackHand oneUser : players) {
			Card[] cards = deck.dealHand(2);
			if (cards == null) {
				return false;
			}
			oneUser.addCards(cards);
		}
		return true;
	}

	/**
	 * get all players who hold Black Jack.
	 *
	 * @return a list of players.
	 */
	List<Integer> getBlackJacks() {
		List<Integer> winners = new ArrayList<>();
		for (int i = 0; i < players.length; i++) {
			if (players[i].isBlackJack()) {
				winners.add(i);
			}
		}
		return winners;
	}

	/**
	 * one user's operation, require cards until reach HIT_UNTIL to get as maximum
	 * score as possible.
	 *
	 * @param player
	 *            this user.
	 * @return <tt>true</tt> if this user require at least one card.
	 */
	boolean playHand(BlackJackHand player) {
		while (player.score() < HIT_UNTIL) {
			Card card = deck.dealCard();
			if (card == null) {
				return false;
			}
			player.addCards(new Card[] { card });
		}
		return true;
	}

	/**
	 * check if there is any play doesn't need card any more.
	 *
	 * @return <tt>true</tt> when there is at least one player doesn't need card any
	 *         more.
	 */
	boolean playAllHand() {
		for (BlackJackHand player : players) {
			if (!playHand(player)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * get the user whose score is highest. traverse all users iteratively.
	 *
	 * @return this player.
	 */
	List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<>();
		int winnerScore = 0;
		for (int i = 0; i < players.length; i++) {
			BlackJackHand player = players[i];
			if (!player.busted()) {
				if (player.score() > winnerScore) {
					winnerScore = player.score();
					winners.clear();
					winners.add(i);
				} else if (player.score() == winnerScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}

	/**
	 * print all players cards, including suit and face value.
	 */
	void printPlayersAndScores() {
		for (int i = 0; i < players.length; i++) {
			System.out.println("Hand " + i + "(" + players[i].score() + "):");
			players[i].print();
			System.out.println();
		}
	}

	/**
	 * the complete game process.
	 */
	void simulate() {
		initializeDeck();
		boolean success = dealInitial();
		if (!success) {
			System.out.print("Error: Run out of cards.");
		} else {
			System.out.println("---Initial----");
			printPlayersAndScores();
			List<Integer> blackJacks = getBlackJacks();
			if (blackJacks.size() > 0) {
				System.out.print("Black Jack lies in:");
				for (int i : blackJacks) {
					System.out.print(i + " ");
				}
				System.out.println();
				System.out.println("done.");
			} else {
				success = playAllHand();
				if (!success) {
					System.out.println("Error: cards out of bound.");
				}
				System.out.println("---Completed Game---");
				printPlayersAndScores();
				List<Integer> winners = getWinners();
				if (winners.size() > 0) {
					System.out.println("Winners:");
					for (int i : winners) {
						System.out.println(i + "");
					}
					System.out.println();
				} else {
					System.out.println("Draw. All players have busted.");
				}
			}
		}
	}

	public static void main(String args[]) {
		BlackJackGameAutomator automator = new BlackJackGameAutomator(5);
		automator.simulate();
	}
}