package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	private Dealer dealer;
	private Player player;
	private Deck deck;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApp bjapp = new BlackjackApp();
		bjapp.run();
		
	}

	public void run() {
		initializeGame();
		playGame();
		whoWon();
		sc.close();
	}

	private void initializeGame() {
		deck = new Deck();
		deck.shuffle();
		player = new Player();
		dealer = new Dealer();
		dealStartingCards();

	}

	private void playGame() {
		playerTurn();
		if (player.isBusted()) {
			return;
		}
		dealerTurn();
	}

	private void playerTurn() {
		dealer.showOneCard();
		while (player.getHandValue() < 21) {
			System.out.println("Player's cards: " + player.getHandValue() + " " + player.getHand());
			System.out.println("Would you like to hit or stay? Enter H or S");
			String hitOrStand = sc.nextLine();
			if (hitOrStand.equals("S")) {
				System.out.println("Player stays with: " + player.getHandValue() + player.getHand());
				break;
			} else {
				player.addCard(deck.dealCard());
				
			}
			
		}
	}

	private void dealerTurn() {
//		System.out.println("Dealer shows: " + dealer.getHandValue() + dealer.getHand());
		while (dealer.getHandValue() < 17) {
			dealer.addCard(deck.dealCard());
			System.out.println("Dealer Hits!");
			System.out.println("Dealer shows: " + dealer.getHandValue() + dealer.getHand());
		}
		System.out.println("Dealer stays with: " + dealer.getHandValue() + dealer.getHand());
		
	}

	private void whoWon() {
		if (player.isBusted()) {
			System.out.println("PLAYER BUSTS. YOU LOSE!");
		} else if (dealer.isBusted()) {
			System.out.println("DEALER BUSTS. YOU WIN!");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("YOU WIN!");
		} else if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("DEALER WINS. YOU LOSE!");
			
		}

	}

	private void dealStartingCards() {
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
	}
}
