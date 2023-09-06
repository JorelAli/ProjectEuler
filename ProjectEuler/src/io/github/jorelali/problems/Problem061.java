package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

import io.github.jorelali.utils.RT;

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
		System.out.println("Existing functions:");
		System.out.println(p3s);
		System.out.println(p4s);
		System.out.println(p5s);
		System.out.println(p6s);
		System.out.println(p7s);
		System.out.println(p8s);
		
		System.out.println("Filtered p8s:");
		List<Integer> p8s2 = p8s.stream().map(this::lastTwoDigits).filter(i -> i > 9).collect(Collectors.toList());
		System.out.println(p8s2);
		
		List<Integer> p3s2 = p3s.stream().filter(i -> p8s2.stream().anyMatch(p8 -> String.valueOf(i).startsWith(String.valueOf(p8)))).collect(Collectors.toList());
		System.out.println("Filtered p3s that start with p8s:" + p3s2);
		List<Integer> p4s2 = p4s.stream().filter(i -> p8s2.stream().anyMatch(p8 -> String.valueOf(i).startsWith(String.valueOf(p8)))).collect(Collectors.toList());
		System.out.println("Filtered p4s that start with p8s:" + p4s2);
		List<Integer> p5s2 = p5s.stream().filter(i -> p8s2.stream().anyMatch(p8 -> String.valueOf(i).startsWith(String.valueOf(p8)))).collect(Collectors.toList());
		System.out.println("Filtered p5s that start with p8s:" + p5s2);
		List<Integer> p6s2 = p6s.stream().filter(i -> p8s2.stream().anyMatch(p8 -> String.valueOf(i).startsWith(String.valueOf(p8)))).collect(Collectors.toList());
		System.out.println("Filtered p6s that start with p8s:" + p6s2);
		List<Integer> p7s2 = p7s.stream().filter(i -> p8s2.stream().anyMatch(p8 -> String.valueOf(i).startsWith(String.valueOf(p8)))).collect(Collectors.toList());
		System.out.println("Filtered p7s that start with p8s:" + p7s2);
		
		// And just sort of repeat all of these:
		// For each of the above filtered streams, find the endings of them, find the next search space, repeat etc.
		// Should probably try to reproduce the simplest case with only 3, 4, 5, then algorithmically increase that.
		
		uptime();
	}
	
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
	
	// Helper functions:
	
	List<Integer> computeDigits(IntUnaryOperator function, int digits) {
		List<Integer> ps = new ArrayList<>();
		final int lowerBound = (int) Math.pow(10, digits - 1) - 1;
		final int upperBound = (int) Math.pow(10, digits);

		for(int i = 0, p = 0; p < upperBound; i++) {
			p = function.applyAsInt(i);
			if (p > lowerBound && p < upperBound) {
				ps.add(p);
			}
		}

		return ps;
	}
	
	int firstTwoDigits(int n) {
		return n / 100;
	}
	
	int lastTwoDigits(int n) {
		return n % 100;
	}
}
