package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem071 extends RT {

	/* https://projecteuler.net/problem=71 
	 * 
	 * https://oeis.org/A006842
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * 
	 * Farey neighbours:
	 * 
	 * If a/b and c/d are next to each other, then:
	 * c/d - a/b = 1/(bd)
	 * 
	 * So: if a/b < 3/7, then 3/7 - a/b = 1/(7b)
	 * 
	 * Therefore, we have this equation:
	 * 1) 3b-7a = 1
	 * 
	 * Given that we want to find the value a (numerator), we have the function:
	 * a = (3b-1)/7
	 * 
	 * Program took 271 milliseconds
	 * */
	
	static double a(double b) {
		return ((3D * b) - 1D) / 7D;
	}
	
	public static void main(final String[] args) {
		
		double max = 0;
		
		for(double d = 0; d <= 1000000; d++) {
			if(Utils.isInteger(a(d))) {
				if(a(d) > max) {
					max = a(d);
				}
			}
		}
		System.out.println(max);
		uptime();
		
	//Initial attempt
		
		
//		Stack<Fraction> fractions = new Stack<Fraction>();
//		int max = 10000;
//		for(int d = 1; d <= max; d++) {
//			for(int n = 1; n < d; n++) {
//				fractions.push( new Fraction(n ,d));
//			}
//		}
//
//		uptime();
//		System.out.println(fractions.size()); // 49,995,000 with max = 10000
//		
//		
//		//Collections.sort(fractions);
//		for (int i = 0; i < fractions.size(); i++) {
//			Fraction fraction = fractions.get(i);
//			if(fraction.getNumerator() == 3 && fraction.getDenominator() == 7) {
//				System.out.println(fractions.get(i-1).getNumerator());
//			}
//		}
//		//fractions.forEach(a -> System.out.println(a.toString()));
//		
//		uptime();
	}
}
