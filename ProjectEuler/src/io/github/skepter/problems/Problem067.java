package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem067 extends RT {

	/* https://projecteuler.net/problem=67 
	 * See problem 18 */
	public static void main(final String[] args) {
		List<String> items = Utils.readFromFile("problem67.txt");
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
