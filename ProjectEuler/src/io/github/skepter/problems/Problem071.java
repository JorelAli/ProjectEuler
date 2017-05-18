package io.github.skepter.problems;

import java.util.Stack;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.fractions.Fraction;

public class Problem071 extends RT {

	/* https://projecteuler.net/problem=71 */
	public static void main(final String[] args) {
		
		
		Stack<Fraction> fractions = new Stack<Fraction>();
		int max = 10000;
		for(int d = 1; d <= max; d++) {
			for(int n = 1; n < d; n++) {
				fractions.push( new Fraction(n ,d));
			}
		}

		uptime();
		System.out.println(fractions.size()); // 49,995,000 with max = 10000
		
		
		//Collections.sort(fractions);
		for (int i = 0; i < fractions.size(); i++) {
			Fraction fraction = fractions.get(i);
			if(fraction.getNumerator() == 3 && fraction.getDenominator() == 7) {
				System.out.println(fractions.get(i-1).getNumerator());
			}
		}
		//fractions.forEach(a -> System.out.println(a.toString()));
		
		uptime();
	}
}
