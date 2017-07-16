package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem054 extends RT {

	/**/
	public static void main(final String[] args) {
		List<String> list = Utils.readFromFile("p054_poker.txt");
		int count = 0;
		for(String str : list) {
			String[] cards = str.split(" ");
			Hand player1 = new Hand(new Card[] {new Card(cards[0]), new Card(cards[1]), new Card(cards[2]), new Card(cards[3]), new Card(cards[4])});
			Hand player2 = new Hand(new Card[] {new Card(cards[5]), new Card(cards[6]), new Card(cards[7]), new Card(cards[8]), new Card(cards[9])});
//			System.out.println(str);
//			System.out.println(player1.getNumericalResult());
//			System.out.println(player2.getNumericalResult());
			if(player1.getNumericalResult() > player2.getNumericalResult()) {
				count++;
			}
			if(player1.getNumericalResult() == player2.getNumericalResult()) {
				
				if(player1.getHighestCard().numericalValue > player2.getHighestCard().numericalValue) {
					count++;
				}
				//System.out.println(str);
				//System.out.println(player1.getNumericalResult());
			}
		}
		
		System.out.println(count);
		
//		Card[] cards = new Card[] {new Card("5H"), new Card("2D"), new Card("3C"), new Card("3S"), new Card("4D")};
		
//		System.out.println(new Hand(cards).isPair());
		
		uptime();
	}
	
	enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES;
	}
	
	static class Hand {
		
		public Card[] cards;
		public int sumOfNumericalValues = 0;
		public int[] numericalValuesSorted;
		public List<Integer> numericalValuesSortedList;
		
		public Hand(Card[] cards) {
			this.cards = cards;
			
			for(Card card : cards) {
				sumOfNumericalValues += card.numericalValue;
			}
			
			List<Integer> sortedCardValues = new ArrayList<Integer>();
			for(Card card : cards) {
				sortedCardValues.add(card.numericalValue);
			}
			Collections.sort(sortedCardValues);
			numericalValuesSortedList = sortedCardValues;
			numericalValuesSorted = sortedCardValues.stream().mapToInt((Integer i) -> i).toArray();
		}
		
		/**
		 * Calculates some kind of number to determine the winner. The higher the number, the higher your chances of winning
		 * @return
		 */
		public int getNumericalResult() {
			if(isRoyalFlush()) {
				return 100;
			}
			if(isStraightFlush()) {
				return 99;
			}
			if(isFourOfAKind()) {
				return 98;
			}
			if(isFullHouse()) {
				return 97;
			}
			if(isFlush()) {
				return 96;
			}
			if(isStraight()) {
				return 95;
			}
			if(isThreeOfAKind()) {
				return 94;
			}
			if(isTwoPairs()) {
				return 93;
			}
			if(isPair()) {
				return 92;
			}
			return getHighestCard().numericalValue;
		}
		
		public Card getHighestCard() {
			Card maxCard = Card.nullCard();
			for(Card card : cards) {
				if(card.numericalValue > maxCard.numericalValue) {
					maxCard = card;
				}
			}
			return maxCard;
		}
		
		public boolean isPair() {
			if(!isTwoPairs()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).collect(Collectors.toSet()).size() == 1;
			} else {
				return false;
			}
		}
		
		public boolean isTwoPairs() {
			if(!isFullHouse()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).collect(Collectors.toSet()).size() == 2;
			} else {
				return false;
			}
		}
		
		public boolean isFullHouse() {
			if(isThreeOfAKind()) {
				boolean three = numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 3).count() > 0;
				boolean two = numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).count() > 0;
				return(three && two);
			} else {
				return false;
			}
		}
		
		public boolean isThreeOfAKind() {
			if(isFourOfAKind()) {
				return false;
			}
			boolean three = numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 3).count() > 0;
			boolean two = numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).count() > 0;
			return(three && !two);
		}
		
		public boolean isFourOfAKind() {
			return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 4).count() > 0;
		}
		
		public boolean isFlush() {
			boolean flush = true;
			Suit cardSuit = cards[0].suit;
			for(Card card : cards) {
				if(card.suit != cardSuit) {
					flush = false;
				}
			}
			return flush;
		}
		
		public boolean isStraight() {
			Card highestCard = getHighestCard();
			int highVal = highestCard.numericalValue;
			int straightValue = highVal + (highVal - 1) + (highVal - 2) + (highVal - 3) + (highVal - 4);
								
			return sumOfNumericalValues == straightValue;
		}
		
		public boolean isStraightFlush() {
			return isStraight() && isFlush();
		}
		
		public boolean isRoyalFlush() {
			return isStraightFlush() && (sumOfNumericalValues == 60); //10 + 11 + 12 + 13 + 14;
		}
		
	}
	
	static class Card {
	
		//e.g. 2, 3, ... 10, J, Q, K, A
		char card; 
		
		//e.g. 2, 3, ... 10, 11, 12, 13, 14 (A = 14 in this case)
		int numericalValue;
		
		Suit suit;
		
		public static Card nullCard() {
			Card nullCard = new Card();
			nullCard.card = '0';
			nullCard.numericalValue = 0;
			nullCard.suit = Suit.SPADES;
			return nullCard;
		}
		
		@Override
		public String toString() {
			switch(suit) {
				case CLUBS:
					return card + "C";
				case DIAMONDS:
					return card + "D";
				case HEARTS:
					return card + "H";
				case SPADES:
					return card + "S";
				default:
					return card + "";
			}
		}
		
		private Card() { }
		
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
