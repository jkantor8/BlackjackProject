package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> hand;
	
	
	public Player () {
		hand = new ArrayList<>();
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void addCard(Card card) {
		hand.add(card);
}
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getRank().getValue();
		}
		return handValue;
	}
	
	public boolean isBusted() {
		return getHandValue() > 21;
	}
}