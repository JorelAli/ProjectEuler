package io.github.jorelali.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;
import io.github.jorelali.utils.fractions.BigBigFraction;

public class Problem065 extends RT {

	public static int pointer = 0;
	public static List<Integer> list;
	public static int term = 100;
	
	/* https://projecteuler.net/problem=65 
	 * Program took 077 milliseconds */
	public static void main(final String[] args) { 
				
		//Array sequence for value of e
		list = new ArrayList<Integer>();
		int k = 1;
		for(int i = 1; i<= 100; i++) {
			list.add(1);
			list.add(2*k);
			k++;
			list.add(1);
		}
		list = list.subList(0, 99);
		
		Collections.reverse(list);
		//Utils.printListSingleLine(list);
	
		/*
		 * 1/1 + 66. flip it. Add 1. flip it. add 1. flip it. add 64...
		 */
		BigBigFraction fraction = new BigBigFraction(BigInteger.ONE, BigInteger.valueOf(list.get(0)));
		for(int i = 1; i < list.size(); i++) {
			 fraction.add(new BigBigFraction(BigInteger.valueOf(list.get(i)), BigInteger.ONE));
			 fraction.flip();
		}
		 fraction.add(new BigBigFraction(BigInteger.valueOf(2L), BigInteger.ONE));
		System.out.println(Utils.sumOfDigits(fraction.getNumerator().toString()));
		
		uptime();
	}

}
