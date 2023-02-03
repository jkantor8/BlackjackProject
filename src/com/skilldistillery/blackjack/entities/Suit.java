package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private final String name;

	private Suit(String n) {
		name = n;
	}
	 @Override
	  public String toString() {
		 return name;
	  }

	
	}