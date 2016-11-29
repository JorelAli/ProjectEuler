package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem018 extends RT {

	/* https://projecteuler.net/problem=18 
	 * 
	 * This method uses some dynamic programming method of 
	 * calculating the two numbers below each pair and comparing them
	 * to find the max value of the path.
	 * 
	 * (Thanks to my maths teacher for teaching me Decision 2 OCR, which
	 * explains how to solve problems via dynamic programming)
	 * 
	 *  (See also: Problem 67)*/
	public static void main(final String[] args) {
		List<String> items = Utils.readFromFile("problem18.txt");
		Collections.reverse(items);
		
		
		//Utils.printList(items);
		
		
		
		List<Integer[]> ints = convertToIntArray(items);
		
		/*
		 * arr = list of each row of numbers
		 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
		 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
		 * 
		 * etc.
		 * 
		 * 95 64
		 * 75
		 */
		
		/*
		 * Initial iteration:
		 */
		Integer[] initI = ints.get(0);
		List<Integer> maxValuesA = new ArrayList<Integer>();
		for(int i = 0; i < initI.length - 1; i++) {
			maxValuesA.add(Math.max(initI[i], initI[i+1]));
		}
		
		//Utils.printListSingleLine(maxValuesA);
		
		
		for(Integer[] row : ints) {
			List<Integer> maxValuesB = new ArrayList<Integer>();
			//Ignore initial case - it has been sorted above
			if(row == ints.get(0))
				continue;
			
			for(int i = 0; i < row.length - 1; i++) {
				maxValuesB.add(Math.max(row[i] + maxValuesA.get(i), row[i + 1] + maxValuesA.get(i + 1)));
			}
			//Utils.printListSingleLine(maxValuesB);
			
			if(maxValuesA.size() == 1) {
				/* Adds the final (top) number to the maximum path of the previous (numbers below) */
				System.out.println(maxValuesA.get(0) + ints.get(ints.size() - 1)[0]);
				uptime();
				return;
			}
			
			maxValuesA.clear();
			maxValuesA.addAll(maxValuesB);
		}
	}
	
	private static List<Integer[]> convertToIntArray(List<String> strings) {
		List<Integer[]> ints = new ArrayList<Integer[]>();
		for(String string : strings) {
			List<Integer> numbers = new ArrayList<Integer>(); 
			for(String s : string.split(" ")) {
				numbers.add(Integer.parseInt(s));
			}
			ints.add(numbers.toArray(new Integer[numbers.size()]));
		}
		return ints;
	}
	
}
