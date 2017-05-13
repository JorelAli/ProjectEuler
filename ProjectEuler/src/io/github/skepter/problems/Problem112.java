package io.github.skepter.problems;

import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem112 extends RT {

	/* https://projecteuler.net/problem=112 
	 * Program took 506 milliseconds */
	public static void main(final String[] args) {
		assert isIncreasing(134468);
		assert isDecreasing(66420);
		assert isBouncy(155349);
		
		double bouncyTotal = 0;
		//Checks to ensure that the code works with the examples from the problem
//		for(int i = 1; i <= 1000; i++) {
//			if(isBouncy(i)) {
//				bouncyTotal++;
//			}
//			
//			if(bouncyTotal / i == 0.5) {
//				assert(i == 538);
//				break;
//			}
//			
//		}
//		
//		bouncyTotal = 0;
//		for(int i = 1; i <= 100000; i++) {
//			if(isBouncy(i)) {
//				bouncyTotal ++;
//			}
//			
//			if(bouncyTotal / i == 0.9) {
//				assert(i == 21780);
//				break;
//			}
//			
//		}
		
		for(int i = 1; i <= Integer.MAX_VALUE; i++) {
		if(isBouncy(i)) {
			bouncyTotal++;
		}
		
		if(bouncyTotal / i == 0.99) {
			System.out.println(i);
			break;
		}
		
	}
		
		uptime();
	}
	
	public static boolean isIncreasing(int n) {
		boolean increasing = true;
		List<Integer> digits = Utils.digits(n);
		for(int i = 0; i < digits.size() - 1; i++) {
			 if(digits.get(i) <= digits.get(i + 1)) {
				 continue;
			 } else {
				 increasing = false;
			 }
		}
		return increasing;
	}
	
	public static boolean isDecreasing(int n) {
		boolean decreasing = true;
		List<Integer> digits = Utils.digits(n);
		for(int i = 0; i < digits.size() - 1; i++) {
			 if(digits.get(i) >= digits.get(i + 1)) {
				 continue;
			 } else {
				 decreasing = false;
			 }
		}
		return decreasing;
	}
	
	public static boolean isBouncy(int n) {
		return !(isDecreasing(n) || isIncreasing(n));
	}
	
}
