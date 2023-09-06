package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.github.jorelali.utils.RT;

public class Problem061 extends RT {

	/* https://projecteuler.net/problem=61 */
	public static void main(final String[] args) {
		
		// Compute sets with 4 digits
		List<Integer> p3s = new ArrayList<>();
		List<Integer> p4s = new ArrayList<>();
		List<Integer> p5s = new ArrayList<>();
		List<Integer> p6s = new ArrayList<>();
		List<Integer> p7s = new ArrayList<>();
		List<Integer> p8s = new ArrayList<>();
		
		for(int i = 0; ; i++) {
			final int p3 = p3(i);
			final int p4 = p4(i);
			final int p5 = p5(i);
			final int p6 = p6(i);
			final int p7 = p7(i);
			final int p8 = p8(i);
			
			if (p3 > 999 && p3 < 10000) {
				p3s.add(p3);
			}
			if (p4 > 999 && p4 < 10000) {
				p4s.add(p4);
			}
			if (p5 > 999 && p5 < 10000) {
				p5s.add(p5);
			}
			if (p6 > 999 && p6 < 10000) {
				p6s.add(p6);
			}
			if (p7 > 999 && p7 < 10000) {
				p7s.add(p7);
			}
			if (p8 > 999 && p8 < 10000) {
				p8s.add(p8);
			}
			
			if (p3 >= 10000 &&
				p4 >= 10000 &&
				p5 >= 10000 &&
				p6 >= 10000 &&
				p7 >= 10000 &&
				p8 >= 10000) {
				break;
			}
			
		}
		
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
		List<Integer> p8s2 = p8s.stream().map(i -> i % 100).filter(i -> i > 9).collect(Collectors.toList());
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
	
	static int p3(int n) {
		return n * (n + 1) / 2;
	}
	
	static int p4(int n) {
		return n * n;
	}
	
	static int p5(int n) {
		return n * ((3 * n) - 1) / 2;
	}
	
	static int p6(int n) {
		return n * ((2 * n) - 1);
	}
	
	static int p7(int n) {
		return n * ((5 * n) - 3) / 2;
	}
	
	static int p8(int n) {
		return n * ((3 * n) - 2);
	}
}
