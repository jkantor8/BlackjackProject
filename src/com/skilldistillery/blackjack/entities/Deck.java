package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(52);

//each Deck has 52 cards. Let's create the 52 cards:
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();

		// for each of the 4 Suits (HEARTS, SPADES, CLUBS, DIAMONDS)
		for (Suit suit : suits) {
			// create each of the 13 ranks (2->Ace)
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}

		}

	}

	public int checkSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
}