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
			
			[1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 1798805207, 1238392738]
			[1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 1798805207]

		 */
		
		List<Long> sequence = analyseSequence(Arrays.asList(new Long[] {16L, 78L, 254L, 634L, 1332L}));
		System.out.println(sequence);
		System.out.println(sequenceToString(sequence));
		System.out.println(evaluateSequence(sequence, 4));
		System.out.println();
		
		long count = 0;
		
		List<Long> seq = new ArrayList<>();
		//Has trouble with i = 9 and i = 10
		for(int i = 1; i <= 10; i++) {
			seq.add(tenDegPoly(i));
			//System.out.println(seq);
			System.out.println(sequenceToString(analyseSequence(new ArrayList<>(seq))));
//			System.out.print(seq + " ");
			
			//Value should NOT be negative!
			System.out.println(evaluateSequence(analyseSequence(new ArrayList<>(seq)), i + 1));
			count += evaluateSequence(analyseSequence(new ArrayList<>(seq)), i + 1);
		}
				
		System.out.println(count);
		
		//System.out.println(analyseSequence(Arrays.asList(new Integer[] {1, 683, 44287})));
		//output: 6n^2−11n+6
		
		
		uptime();
	}
	
	public static long tenDegPoly(int n) {
		return 1 - n + pow(n, 2) - pow(n, 3) + pow(n, 4) - pow(n, 5) + pow(n, 6) - pow(n, 7) + pow(n, 8) - pow(n, 9) + pow(n, 10);
	}
	
	public static long pow(long i, long pow) {
		return (int) Math.pow(i, pow);
	}
	
	public static String sequenceToString(List<Long> sequence) {
		String result = "";
		for(int i = 0; i < sequence.size(); i++) {
			result = result + (sequence.get(i) > 0 ? "+ " : "") + sequence.get(i) + "x^" + (sequence.size() - i - 1) + " ";
		}
		return result;
	}
	
	public static long evaluateSequence(List<Long> sequence, long n) {
		long result = 0;
		for(int i = 0; i < sequence.size(); i++) {
			result += (sequence.get(i) * pow(n, sequence.size() - i - 1));
		}
		return result;
		
	}
	
	/**
	 * WILL ONLY ACCURATELY DETERMINE SEQUENCE IF:
	 * Number of elements in the list = Polynomial degree + 1
	 * @param sequence
	 * @return
	 */
	public static List<Long> analyseSequence(List<Long> sequence) {
		if(sequence.size() == 1) {
			return sequence;
		}
		return analyseSequence(sequence, new ArrayList<>());
	}
	
	public static List<Long> analyseSequence(List<Long> sequence, List<Long> oldOutput) {
		List<Long> output = oldOutput;
				
		//Determine the polynomial degree by the length of the sequence
		long polynomialDegree = sequence.size() - 1;
		
		if(polynomialDegree == 1) {
			long n = (sequence.get(1) - sequence.get(0));
			//output = output + (n >= 0 ? "+" : "") + n + "n ";
			output.add(n);
			
			long lastTerm = sequence.get(0) - n;
			//Basically the base case.
			//output = output + (lastTerm >= 0 ? "+" : "") + lastTerm;
			output.add(lastTerm);
		} else {
			//recursion recursion recursion!
			
			//Find the final "recursive difference" (at the bottom of differences)
					
			List<Long> tempSequence = new ArrayList<>(sequence);
			List<Long> differences = new ArrayList<>();
			
			while(true) {
				for (int i = 0; i < tempSequence.size() - 1; i++) {
					differences.add(tempSequence.get(i + 1) - tempSequence.get(i));
				}
				
				//If all of the differences are the same...
				//https://stackoverflow.com/a/29288616
				if(differences.stream().distinct().limit(2).count() <= 1 && differences.size() != 1) {
					return analyseSequence(sequence.subList(0, 2), output);
				}
				
				if(differences.size() != 1) {
					tempSequence = new ArrayList<>(differences);
					differences = new ArrayList<>();
				} else {
					break;
				}
			}
			long firstTerm = differences.get(0) / Utils.factorial(polynomialDegree);
			//output = output + (firstTerm >= 0 ? "+" : "") + firstTerm + "n^" + polynomialDegree;
			output.add(firstTerm);
			
			//Generate the next sequence
			
			List<Long> tempSequence2 = new ArrayList<>();
			for(int i = 0; i < sequence.size() - 1; i++) {
				tempSequence2.add(sequence.get(i) - (firstTerm * pow((i + 1), polynomialDegree) ));
			}
			
			//recursive step
			
			return analyseSequence(tempSequence2, output);
		}
		
		return output;
	}
}
