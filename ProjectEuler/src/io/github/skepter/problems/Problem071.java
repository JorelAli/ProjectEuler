package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;
import io.github.skepter.utils.fractions.Fraction;

public class Problem071 extends RT {

	/* https://projecteuler.net/problem=71 */
	public static void main(final String[] args) {

		
		
//		List<Fraction> fractions = new ArrayList<Fraction>();
//		fractions.add(new Fraction(2,5));
//		fractions.add(new Fraction(2,7));
//		fractions.add(new Fraction(4,7));
//		fractions.add(new Fraction(7,8));
//		//Expected: 2/7, 2/5, 4/7, 7/8
//		Collections.sort(fractions);
//		fractions.forEach(a -> System.out.println(a.toString()));
		
		
		List<Fraction> fractions = new ArrayList<Fraction>();
//		List<Double> fractions = new ArrayList<Double>();
		int max = 10000;
//		LoadingBar bar = new LoadingBar("Problem 71", max);
		for(int d = 1; d <= max; d++) {
			for(int n = 1; n < d; n++) {
				Fraction fraction = new Fraction(n,d);
				if(!fraction.canBeSimplified()) {
					fractions.add(fraction);
				}
//				//if(Utils.gcd(n, d) == 1) {
//				System.out.println(n);
//					fractions.add((double) n/ (double) d);
//					//fractions.add(new Fraction(n,d));
//				//}
			}
//			bar.updateBar(d);
		}
//		System.out.println("Fractions generated");
////		Collections.sort(fractions);
//		System.out.println("Fractions sorted");
		for (int i = 0; i < fractions.size(); i++) {
			Fraction fraction = fractions.get(i);
			if(fraction.getNumerator() == 3 && fraction.getDenominator() == 7) {
				System.out.println(fractions.get(i-1).getNumerator());
			}
		}
		//System.out.println(fractions.get(fractions.indexOf(new Fraction(3,7))).getNumerator());
		//fractions.forEach(a -> System.out.println(a.toString()));
		
		uptime();
	}
}
