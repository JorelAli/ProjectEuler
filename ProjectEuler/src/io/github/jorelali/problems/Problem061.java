package io.github.jorelali.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.IntUnaryOperator;

import io.github.jorelali.utils.RT;

@SuppressWarnings("unchecked")
public class Problem061 extends RT {

	/* https://projecteuler.net/problem=61 */
	public static void main(final String[] args) {
		new Problem061();
	}
	
	public Problem061() {
		// Compute sets with 4 digits
		List<Integer> p3s = computeDigits(this::p3, 4);
		List<Integer> p4s = computeDigits(this::p4, 4);
		List<Integer> p5s = computeDigits(this::p5, 4);
		List<Integer> p6s = computeDigits(this::p6, 4);
		List<Integer> p7s = computeDigits(this::p7, 4);
		List<Integer> p8s = computeDigits(this::p8, 4);
		
		
		// We know that p8s are going to have the smallest list, so let's start with
		// finding p3s that start with the end of p8s
//		System.out.println("Existing functions:");
//		System.out.println(p3s);
//		System.out.println(p4s);
//		System.out.println(p5s);
		/*
		System.out.println(p6s);
		System.out.println(p7s);
		System.out.println(p8s);
		
		System.out.println("Filtered p8s:");
		List<Integer> lastTwoDigitsp8 = p8s.stream().map(this::lastTwoDigits).filter(i -> i > 9).collect(Collectors.toList());
		System.out.println(lastTwoDigitsp8);

		List<Integer> firstTwoDigitsp8 = p8s.stream().map(this::firstTwoDigits).filter(i -> i > 9).collect(Collectors.toList());
		// System.out.println(lastTwoDigitsp8);
		
		List<Integer> p3s2 = p3s.stream().filter(i -> lastTwoDigitsp8.stream().anyMatch(p8 -> firstTwoDigits(i) == lastTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p3s that start with p8s:" + p3s2);
		List<Integer> p4s2 = p4s.stream().filter(i -> lastTwoDigitsp8.stream().anyMatch(p8 -> firstTwoDigits(i) == lastTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p4s that start with p8s:" + p4s2);
		List<Integer> p5s2 = p5s.stream().filter(i -> lastTwoDigitsp8.stream().anyMatch(p8 -> firstTwoDigits(i) == lastTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p5s that start with p8s:" + p5s2);
		List<Integer> p6s2 = p6s.stream().filter(i -> lastTwoDigitsp8.stream().anyMatch(p8 -> firstTwoDigits(i) == lastTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p6s that start with p8s:" + p6s2);
		List<Integer> p7s2 = p7s.stream().filter(i -> lastTwoDigitsp8.stream().anyMatch(p8 -> firstTwoDigits(i) == lastTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p7s that start with p8s:" + p7s2);
		
		List<Integer> p3s3 = p3s.stream().filter(i -> firstTwoDigitsp8.stream().anyMatch(p8 -> lastTwoDigits(i) == firstTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p3s that end with p8s:" + p3s3);
		List<Integer> p4s3 = p4s.stream().filter(i -> firstTwoDigitsp8.stream().anyMatch(p8 -> lastTwoDigits(i) == firstTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p4s that end with p8s:" + p4s3);
		List<Integer> p5s3 = p5s.stream().filter(i -> firstTwoDigitsp8.stream().anyMatch(p8 -> lastTwoDigits(i) == firstTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p5s that end with p8s:" + p5s3);
		List<Integer> p6s3 = p6s.stream().filter(i -> firstTwoDigitsp8.stream().anyMatch(p8 -> lastTwoDigits(i) == firstTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p6s that end with p8s:" + p6s3);
		List<Integer> p7s3 = p7s.stream().filter(i -> firstTwoDigitsp8.stream().anyMatch(p8 -> lastTwoDigits(i) == firstTwoDigits(p8))).collect(Collectors.toList());
		System.out.println("Filtered p7s that end with p8s:" + p7s3);
		
		// And just sort of repeat all of these:
		// For each of the above filtered streams, find the endings of them, find the next search space, repeat etc.
		// Should probably try to reproduce the simplest case with only 3, 4, 5, then algorithmically increase that.
		System.out.println();
		
		*/
		
		// Okay let's try a different approach...
		
		// Find all p3 -> p4 numbers
//		printSequences("3 -> 4: ", p3s, p4s);
//		printSequences("3 -> 5: ", p3s, p5s);
//		
//		printSequences("4 -> 3: ", p4s, p3s);
//		printSequences("4 -> 5: ", p4s, p5s);
//		
//		printSequences("5 -> 3: ", p5s, p3s);
//		printSequences("5 -> 4: ", p5s, p4s);
//		
//		// For all 3 -> 4, we need to find a corresponding 4 -> 5 (and then a corresponding 5 -> 3)
//		
//		List<Integer> a = getSequences(p3s, p4s);
//		
//		print = true;
////		System.out.println(getSequences(p3s, p4s));
//		System.out.println(getSequences(a, p5s));
//		print = false;
//		System.out.println(getSequences(getSequences(getSequences(p3s, p4s), p5s), p3s));
		
		// Obviously this should fail. Our desired sequence is p3, p5, p4, (p3)
		drawSequences(p3s, p4s, p5s);
		
		drawSequences(p3s, p5s, p4s);
		
//		System.out.println("3 -> 4: " + p3s.stream().filter(p3 -> p4s.stream().anyMatch(p4 -> lastTwoDigits(p3) == firstTwoDigits(p4))).collect(Collectors.toList()));
//		System.out.println("4 -> 5: " + p4s.stream().filter(p4 -> p5s.stream().anyMatch(p5 -> lastTwoDigits(p4) == firstTwoDigits(p5))).collect(Collectors.toList()));
//		System.out.println("5 -> 3: " + p5s.stream().filter(p5 -> p3s.stream().anyMatch(p3 -> lastTwoDigits(p5) == firstTwoDigits(p3))).collect(Collectors.toList()));
		
		uptime();
	}
	
	static boolean print = false;
	
	// Figurate functions:
	
	int p3(int n) {
		return n * (n + 1) / 2;
	}
	
	int p4(int n) {
		return n * n;
	}
	
	int p5(int n) {
		return n * ((3 * n) - 1) / 2;
	}
	
	int p6(int n) {
		return n * ((2 * n) - 1);
	}
	
	int p7(int n) {
		return n * ((5 * n) - 3) / 2;
	}
	
	int p8(int n) {
		return n * ((3 * n) - 2);
	}
	
	// More helper functions:
	
	void drawSequences(List<Integer>... lists) {
		// [
		//   [1521, 2147],
		//   ...
		// ]
		List<Deque<Integer>> list = new ArrayList<>();
		
		for(int i : lists[0]) {
			Deque<Integer> deque = new ArrayDeque<>();
			deque.add(i);
			list.add(deque);
		}
		
		for(int i = 0; i < lists.length - 1; i++) {
			List<Integer> firstList = lists[i];
			List<Integer> secondList = lists[i + 1];
			
			for(int pFirst : firstList) {
				for(int pSecond : secondList) {
					if (isSequence(pFirst, pSecond)) {
						
						// Find any existing list where the last element is the first element
						for(Deque<Integer> l : list) {
							if (l.peekLast() == pFirst) {
								l.addLast(pSecond);
							}
						}
						
						// map.put(pSecond, pFirst + "->" + pSecond);
					}
				}
			}
		}
		
//		System.out.println(list);
		
		// Filter length
		list = list.stream().filter(l -> l.size() == lists.length).toList();
		
		// Check last sequence
		list = list.stream().filter(l -> isSequence(l.peekLast(), l.peekFirst())).toList();
		
		System.out.println(list);
	}
	
	boolean isSequence(int pFirst, int pSecond) {
		pFirst = lastTwoDigits(pFirst);
		pSecond = firstTwoDigits(pSecond);
		return pFirst > 9 && pSecond > 9 && String.valueOf(pSecond).startsWith(String.valueOf(pFirst));
	}
	
	void printSequences(String heading, List<Integer> first, List<Integer> second) {
		System.out.println(heading + getSequences(first, second));
	}
	
	List<Integer> getSequences(List<Integer> first, List<Integer> second) {
		List<Integer> newList = new ArrayList<>();
		for(int pFirst : first) {
			for(int pSecond : second) {
				if (isSequence(pFirst, pSecond)) {
					newList.add(pSecond);
					if(print) {
						System.out.println(pFirst + "->" + pSecond);
					}
				}
			}
		}
		return newList.stream().distinct().sorted().toList();
//		return newList;
		// return first.stream().filter(pFirst -> second.stream().anyMatch(pSecond -> isSequence(pFirst, pSecond))).collect(Collectors.toList());
	}
	
	// Helper functions:
	
	List<Integer> computeDigits(IntUnaryOperator function, int digits) {
		List<Integer> ps = new ArrayList<>();
		final int lowerBound = (int) Math.pow(10, digits - 1) - 1;
		final int upperBound = (int) Math.pow(10, digits);

		for(int i = 0, p = 0; p < upperBound; i++) {
			p = function.applyAsInt(i);
			if (p > lowerBound && p < upperBound) {
				
				// Check the last two digits - if they're 00 - 09, discard them
				if (p % 100 > 9) {
					ps.add(p);
				}
			}
		}

		return ps.stream().sorted().toList();
	}
	
	int firstTwoDigits(int n) {
		return n / 100 > 9 ? n / 100 : -1;
	}
	
	int lastTwoDigits(int n) {
		return n % 100 > 9 ? n % 100 : -2;
	}
}
