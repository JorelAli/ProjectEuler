package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import io.github.skepter.utils.RT;

public class Problem084 extends RT {

	final static int DICE_SIZE = 4;
	final static int TRIALS = 10000000;
	
	static int doublesMade = 0;
	static int currentSquare = 0;
	
	static LinkedList<Integer> cc = new LinkedList<Integer>();
	static LinkedList<Integer> ch = new LinkedList<Integer>();	
	
	static int[] squareLandCountArr = new int[40];
	//static HashMap<Integer, Integer> squareLandCount = new HashMap<Integer, Integer>();
	
	/* https://projecteuler.net/problem=84 
	 * What are the top 3 most likely squares to land on in a game of monopoly
	 * if you used two 4 sided dice instead of two 6 sided dice? 
	 * 
	 * Program took 331 milliseconds */
	public static void main(final String[] args) {
		
		for(int i = 1; i <= 16; i++) {
			cc.add(i);
			ch.add(i);
		}
		
		Collections.shuffle(cc);
		Collections.shuffle(ch);
				
		for(int i = 0; i < TRIALS; i++) {
			rollDice();
//			if(currentSquare == 2 || currentSquare == 17 || currentSquare == 33) {
//				doCommunityChest(); //do community chest
//			} else if(currentSquare == 30) {
//				currentSquare = 10; //go to jail
//			} else if(currentSquare == 7 || currentSquare == 22 || currentSquare == 36) {
//				doChance();
//			}
			
			//System.out.println("new current square is " + currentSquare);
			endTurn();
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		SortedSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < 40; i++) {
			list.add(squareLandCountArr[i]);
			set.add(squareLandCountArr[i]);
		}
		
		String str = "";
		for(int i = 0; i < 3; i++) {
			str = str + list.indexOf(set.last());
			set.remove(set.last());
		}
		System.out.println(str);
		
		
//		for(Entry<Integer, Integer> entry : squareLandCount.entrySet()) {
//			//System.out.println(entry.getKey() + ": " + entry.getValue());
//			list.add(entry.getValue());
//		}
//		
//		TreeMap<Integer, Integer> reverse = new TreeMap<Integer, Integer>();
//		for(Entry<Integer, Integer> entry : squareLandCount.entrySet()){
//			reverse.put(entry.getValue(), entry.getKey());
//		}
//		
//		for(int key : reverse.keySet()) {
//			System.out.println(key + ": " + reverse.get(key));
//		}
		
		uptime();
	}
	
	public static void rollDice() {
		boolean doubleMade = false;
		int dice1 = ThreadLocalRandom.current().nextInt(1, DICE_SIZE + 1);
		int dice2 = ThreadLocalRandom.current().nextInt(1, DICE_SIZE + 1);
		
		//System.out.println("Rolled a " + dice1 + " and a " + dice2);
		//System.out.println("Current square is " + currentSquare);
		
		if(dice1 == dice2) {
			doubleMade = true;
			doublesMade++;
			
			if(doublesMade == 3) {
				doublesMade = 0;
				currentSquare = 10;
				return;
			}
		}
		
		currentSquare = currentSquare + dice1 + dice2;
		if (currentSquare > 39) {
			currentSquare = currentSquare % 40;
		}
		
		if(doubleMade) {
			endTurn();
			//endTurn();
			//handle some kind of end turn here
			rollDice();
		} else {
			doublesMade = 0;
		}
		
		if(currentSquare == 7 || currentSquare == 22 || currentSquare == 36) {
			doChance();
		}
		
		if(currentSquare == 2 || currentSquare == 17 || currentSquare == 33) {
			doCommunityChest(); //do community chest
		} else if(currentSquare == 30) {
			currentSquare = 10; //go to jail
		}  		
	}
	
	/*
	 * Picks up the next card and puts it to the bottom of the pile of cards
	 */
	public static int pickCommunityChest() {
		int result = cc.pop();
		cc.offer(result);
		return result;
	}
	
	/*
	 * Picks up the next card and puts it to the bottom of the pile of cards
	 */
	public static int pickChance() {
		int result = ch.pop();
		ch.offer(result);
		return result;
	}
	
	public static void doChance() {
		int val = pickChance();
		switch(val) {
			case 1:
				currentSquare = 0;
				break;
			case 2:
				currentSquare = 10;
				break;
			case 3:
				currentSquare = 11;
				break;
			case 4:
				currentSquare = 24;
				break;
			case 5:
				currentSquare = 39;
				break;
			case 6:
				currentSquare = 5;
				break;
			case 7:
			case 8:
				if(currentSquare == 7) {
					currentSquare = 15;
				} else if(currentSquare == 22) {
					currentSquare = 25;
				} else if(currentSquare == 36) {
					currentSquare = 5;
				}
				break;
			case 9:
				if(currentSquare == 7) {
					currentSquare = 12;
				} else if(currentSquare == 22) {
					currentSquare = 28;
				} else if(currentSquare == 36) {
					currentSquare = 12;
				}
				break;
			case 10:
				if(currentSquare == 7) {
					currentSquare = 4;
				} else if(currentSquare == 22) {
					currentSquare = 19;
				} else if(currentSquare == 36) {
					currentSquare = 33;
				}
				//currentSquare -= 3;
				break;
			default:
				return;
		}
	}
	
	public static void doCommunityChest() {
		int val = pickCommunityChest();
		if(val == 1) {
			currentSquare = 0;
		} else if(val == 2) {
			currentSquare = 10;
		} else {
			return;
		}
	}
	
	public static void endTurn() {
		squareLandCountArr[currentSquare] = squareLandCountArr[currentSquare] + 1;
//		squareLandCount.put(currentSquare, squareLandCount.getOrDefault(currentSquare, 0) + 1);
		//add current square to square land count
	}
	
	
}
