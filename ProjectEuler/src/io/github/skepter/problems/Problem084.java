package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import io.github.skepter.utils.RT;

public class Problem084 extends RT {

	final static int DICE_SIZE = 6;
	final static int TRIALS = 10000000;
	
	static int doublesMade = 0;
	static int currentSquare = 0;
		
	
	static HashMap<Integer, Integer> squareLandCount = new HashMap<Integer, Integer>();
	
	/* https://projecteuler.net/problem=84 
	 * What are the top 3 most likely squares to land on in a game of monopoly
	 * if you used two 4 sided dice instead of two 6 sided dice? */
	public static void main(final String[] args) {
		
		for(int i = 0; i < TRIALS; i++) {
			rollDice();
			if(currentSquare == 2 || currentSquare == 17 || currentSquare == 33) {
				doCommunityChest(); //do community chest
			} else if(currentSquare == 30) {
				currentSquare = 10; //go to jail
			} else if(currentSquare == 7 || currentSquare == 22 || currentSquare == 36) {
				doChance();
			}
			
			//System.out.println("new current square is " + currentSquare);
			endTurn();
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(Entry<Integer, Integer> entry : squareLandCount.entrySet()) {
			//System.out.println(entry.getKey() + ": " + entry.getValue());
			list.add(entry.getValue());
		}
		
		TreeMap<Integer, Integer> reverse = new TreeMap<Integer, Integer>();
		for(Entry<Integer, Integer> entry : squareLandCount.entrySet()){
			reverse.put(entry.getValue(), entry.getKey());
		}
		
		for(int key : reverse.keySet()) {
			System.out.println(key + ": " + reverse.get(key));
		}
		
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
			rollDice();
		}
		
	}
	
	public static void doChance() {
		int val = ThreadLocalRandom.current().nextInt(1, 17);
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
				currentSquare -= 3;
				break;
			default:
				return;
		}
	}
	
	public static void doCommunityChest() {
		int val = ThreadLocalRandom.current().nextInt(1, 17);
		if(val == 1) {
			currentSquare = 0;
		} else if(val == 2) {
			currentSquare = 10;
		} else {
			return;
		}
	}
	
	public static void endTurn() {
		squareLandCount.put(currentSquare, squareLandCount.getOrDefault(currentSquare, 0) + 1);
		//add current square to square land count
	}
	
	
}
