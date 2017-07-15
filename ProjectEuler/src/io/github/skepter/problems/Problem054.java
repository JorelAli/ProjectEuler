package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem054 extends RT {

	/**/
	public static void main(final String[] args) {
		Utils.readFromFile("p054_poker.txt");
		uptime();
	}
	
	enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES;
	}
	
	class Hand {
		
		public Card[] cards;
		
		public Hand(Card[] cards) {
			this.cards = cards;
		}
		
		public Card getHighestCard() {
			for(Card card : cards) {
				
			}
			return null;
		}
		
	}
	
	class Card {
	
		//e.g. 2, 3, ... 10, J, Q, K, A
		char card; 
		
		//e.g. 2, 3, ... 10, 11, 12, 13, 14 (A = 14 in this case)
		int numericalValue;
		
		Suit suit;
		
		public Card(String str) {
			card = str.toCharArray()[0];
			switch(card) {
				case '2':
					numericalValue = 2;
					break;
				case '3':
					numericalValue = 3;
					break;
				case '4':
					numericalValue = 4;
					break;
				case '5':
					numericalValue = 5;
					break;
				case '6':
					numericalValue = 6;
					break;
				case '7':
					numericalValue = 7;
					break;
				case '8':
					numericalValue = 8;
					break;
				case '9':
					numericalValue = 9;
					break;
				case 'T':
					numericalValue = 10;
					break;
				case 'J':
					numericalValue = 11;
					break;
				case 'Q':
					numericalValue = 12;
					break;
				case 'K':
					numericalValue = 13;
					break;
				case 'A':
					numericalValue = 14;
					break;
			}
			
			switch(str.toCharArray()[1]) {
				case 'H':
					suit = Suit.HEARTS;
					break;
				case 'D':
					suit = Suit.DIAMONDS;
					break;
				case 'S':
					suit = Suit.SPADES;
					break;
				case 'C':
					suit = Suit.CLUBS;
					break;
			}
		}
		
	}
}
