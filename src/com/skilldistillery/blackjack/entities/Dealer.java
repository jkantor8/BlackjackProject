package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private boolean showCard;
	
	public Dealer() {
		showCard = false;
		
	}
	
	public boolean isShowingCard() {
		return showCard;
	}
	public void setShowCard(boolean showCard) {
		this.showCard = showCard;
	}
	public void showOneCard() {
		setShowCard(true);
		Card firstCard = getHand().get(0);
		System.out.println(firstCard);

	}

	@Override
	public String toString() {
		return "Dealer [showCard=" + showCard + "]";
	}
}
