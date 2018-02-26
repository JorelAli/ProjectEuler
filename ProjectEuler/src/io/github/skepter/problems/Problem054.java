package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem054 extends RT {

	/* https://projecteuler.net/problem=54
	 * 
	 * How many games does player 1 win from the given file (p054_poker.txt)?
	 * Program took 211 milliseconds */
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
		 * 
		 * Each "option" has a "separation" of 100 points
		 */
		public int getNumericalResult() {
			if(isRoyalFlush()) {
				//Basically instant win.
				return 900;
			}
			if(isStraightFlush()) {
				return 800;
			}
			if(isFourOfAKind()) {
				return 700 + fourOfAKindValue();
			}
			//evalu
			if(isFullHouse()) {
				return 600;
			}
			if(isFlush()) {
				return 500;
			}
			//blah..
			if(isStraight()) {
				return 400;
			}
			//See below
			if(isThreeOfAKind()) {
				return 300 + threeOfAKindValue();
			}
			//See below
			if(isTwoPairs()) {
				return 200 + twoPairValue();
			}
			//What if player 2s pair > player 1s pair?
			if(isPair()) {
				return 100 + pairValue();
			}
			//If highest card, then what about second highest (etc.)
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
		
		//Return value of the pair (so a pair of 2s would return 2)
		public int pairValue() {
			if(isPair()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).collect(Collectors.toList()).get(0);
			} else {
				return -1;
			}
		}
		
		public boolean isTwoPairs() {
			if(!isFullHouse()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).collect(Collectors.toSet()).size() == 2;
			} else {
				return false;
			}
		}
		
		public int twoPairValue() {
			if(isTwoPairs()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 2).collect(Collectors.toList()).get(0);
			} else {
				return -1;
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
		
		public int threeOfAKindValue() {
			if(!isFullHouse() && isThreeOfAKind()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 3).collect(Collectors.toList()).get(0); 
			} else {
				return -1;
			}
		}
		
		public boolean isFourOfAKind() {
			return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 4).count() > 0;
		}
		
		public int fourOfAKindValue() {
			if(isFourOfAKind()) {
				return numericalValuesSortedList.stream().filter(i -> Collections.frequency(numericalValuesSortedList, i) == 4).collect(Collectors.toList()).get(0);
			} else {
				return -1;
			}
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
