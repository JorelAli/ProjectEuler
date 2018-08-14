package io.github.jorelali.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.github.jorelali.utils.RT;

public class Problem622 extends RT {

	/*
	 * A riffle shuffle is executed as follows: a deck of cards is split into
	 * two equal halves, with the top half taken in the left hand and the bottom
	 * half taken in the right hand. Next, the cards are interleaved exactly,
	 * with the top card in the right half inserted just after the top card in
	 * the left half, the 2nd card in the right half just after the 2nd card in
	 * the left half, etc. (Note that this process preserves the location of the
	 * top and bottom card of the deck)
	 * 
	 * Let s(n) be the minimum number of consecutive riffle shuffles needed to
	 * restore a deck of size n to its original configuration, where n is a
	 * positive even number.
	 * 
	 * Amazingly, a standard deck of 52 cards will first return to its original
	 * configuration after only 8 perfect shuffles, so s(52)=8. It can be
	 * verified that a deck of 86 cards will also return to its original
	 * configuration after exactly 8 shuffles, and the sum of all values of n
	 * that satisfy s(n)=8 is 412.
	 * 
	 * Find the sum of all values of n that satisfy s(n)=60.
	 */
	
	/*
	 * 	Count: 109, Sum: 400002
	 *	Program took 11 seconds, 881 milliseconds
	 */
	
	/**
	 * Status:
	 * - It works
	 * - It still doesn't filter out 6 and 16, because 1/2 isn't good enough, 1/4 and 1/3 still exist...
	 */
	
	static final int sN_VALUE = 60;
	
	public static void main(final String[] args) {
				
		//System.out.println(generateList(10));
		//s(10);
		
		//System.out.println(generateList(16));
		//s(16);
		
		//System.out.println();
		
		//analyse(52);
		long count = 0;
		for(int i = 2; i < 1_000; i+=2) {
			int solve = solveBigInt(i);
			if(solve != 0)
				System.out.println(solve);
			count += solve;
		}
		System.out.println("R: " + count);
		
		/*
		 * 18
52
86
256
		 */
		
//		final int MAX = 1000;
//		int count = 0;
//		int sum = 0;
//		for(int i = 2; i < MAX; i+=2) {
//			if(s(i) == sN_VALUE) {
//				count++;
//				sum += i;
//				System.out.println(i);
//			}
//		}
//		System.out.println("Count: " + count + ", Sum: " + sum);
		
		uptime();
	}
	
	//After statistical analysis:
	//Follows pattern 2^n + 1
	
	/*
	 * 
	 * 
	 */
	
	public static int solveBigInt(int n) {
		BigInteger afterShuffle = BigInteger.valueOf(2).pow(sN_VALUE - 1).add(BigInteger.ONE).mod(BigInteger.valueOf(n - 1));
		BigInteger halfShuffle = BigInteger.valueOf(2).pow((sN_VALUE/2) - 1).add(BigInteger.ONE).mod(BigInteger.valueOf(n - 1));
		if(halfShuffle.intValue() == (n/2 + 1)) {
			return 0;
		}
		//Int value exists because we're using mod.
		if(afterShuffle.intValue() == (n/2 + 1)) {
			return n;
		} else {
			return 0;
		}
	}
	
	public static int solve(int n) {
		//take a number (52).
		//Half it + 1 (27)
		//Solve 2^n + 1, where n = 
		if(((Math.pow(2, sN_VALUE - 1) + 1) % (n - 1)) == (n/2 + 1)) {
			return n;
		} else {
			return 0;
		}
	}
	
	public static void analyse(int n) {
		for(int i = 0; i < sN_VALUE; i++) {
			System.out.println((Math.pow(2, i) + 1) % (n-1));
		}
	}
	/*
	 * 
	 * 
	 */
	public static int s(int n) {
		List<Integer> originalList = generateList(n);
		List<Integer> newList = originalList;
		int count = 0;
		do {
			newList = performShuffle(newList);
			System.out.println(newList);
			if(++count > sN_VALUE) {
				return -1;
			}
		} while(!originalList.equals(newList));
		return count;
	}
	
	public static List<Integer> generateList(int size) {
		return IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
	}
	
	//Returns a list after one riffle shuffle
	public static List<Integer> performShuffle(List<Integer> list) {
		//Split the deck
		
		List<Integer> left = list.subList(0, list.size() / 2); //top half
		List<Integer> right = list.subList(list.size() / 2, list.size()); //bottom half
		
		//left right left right...
		
		List<Integer> newList = new ArrayList<>();
		for(int i = 0; i < left.size(); i++) {
			newList.add(left.get(i));
			newList.add(right.get(i));
		}
		
		return newList;
	}
}
