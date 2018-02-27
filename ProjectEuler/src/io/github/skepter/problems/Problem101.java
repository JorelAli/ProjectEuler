package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem101 extends RT {

	/* Fits and bops. */
	public static void main(final String[] args) {
		
		/*
		 *  1
			683 		//find linear sequence 1, 683, ...
			44287 		//find quadratic sequence 1, 683, 44287, ...
			838861		//find cubic sequence 1, 683, 44287, 838861, ...
			8138021
			51828151
			247165843
			954437177
			1798805207
			1238392738
		 */
		
//		for(int i = 1; i <= 10; i++)
//			System.out.println(tenDegPoly(i));
		
		
		System.out.println(analyseSequence(Arrays.asList(new Integer[] {1, 8, 27})));
		
		
		uptime();
	}
	
	public static int tenDegPoly(int n) {
		return 1 - n + pow(n, 2) - pow(n, 3) + pow(n, 4) - pow(n, 5) + pow(n, 6) - pow(n, 7) + pow(n, 8) - pow(n, 9) + pow(n, 10);
	}
	
	public static int pow(int i, int pow) {
		return (int) Math.pow(i, pow);
	}
	
	public static String analyseSequence(List<Integer> sequence) {
		return analyseSequence(sequence, "");
	}
	
	public static String analyseSequence(List<Integer> sequence, String currentSequence) {
		String output = "";
		
		
		//Determine the polynomial degree by the length of the sequence
		int polynomialDegree = sequence.size() - 1;
		
		if(polynomialDegree == 1) {
			int n = (sequence.get(1) - sequence.get(0));
			output = n + "n";
			
			int lastTerm = sequence.get(0) - n;
			//Basically the base case.
			output = output + lastTerm;
		} else {
			//recursion recursion recursion!
			
			//Find the final "recursive difference" (at the bottom of differences)
					
			List<Integer> tempSequence = new ArrayList<>(sequence);
			List<Integer> differences = new ArrayList<>();
			
			while(true) {
				for (int i = 0; i < tempSequence.size() - 1; i++) {
					differences.add(tempSequence.get(i + 1) - tempSequence.get(i));
				}
				
				if(differences.size() != 1) {
					tempSequence = new ArrayList<>(differences);
					differences = new ArrayList<>();
				} else {
					break;
				}
			}
			int firstTerm = differences.get(0) / Utils.factorial(polynomialDegree);
			System.out.println(firstTerm + "n^" + polynomialDegree);
			
		}
		
		
		
		
		return currentSequence + output;
	}
}
