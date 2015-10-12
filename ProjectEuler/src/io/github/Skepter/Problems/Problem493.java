package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Abandoned;
import io.github.Skepter.Utils.RT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem493 extends RT implements Abandoned {

	// 70 colored balls are placed in an urn, 10 for each of the seven rainbow
	// colors.
	//
	// What is the expected number of distinct colors in 20 randomly picked
	// balls?
	//
	// Give your answer with nine digits after the decimal point (a.bcdefghij).

	//Answer uses combinatorics. Not Advanced Enough
	public static void main(final String[] args) {		
		int runs = 1000; // 10 million
		double c = 0;

		for (int m = 0; m < runs; m++) {
			List<Integer> urn = new ArrayList<Integer>();

			/* Fill urn with balls */
			Random random = new Random();
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 10; j++) {
					urn.add(i);
				}
			}

			List<Integer> balls = urn.subList(0, 20);

			for (int i = 0; i < 20; i++) {
				int selection = random.nextInt(70);
				balls.add(urn.get(selection));
				// urn.remove(selection);
			}

			// int count = 0;
			for (int i = 0; i < 7; i++) {
				if (Collections.frequency(balls, i) != 0) {
					// count++;
					c++;
				}
			}
		}

		// for (int m = 0; m < runs; m++) {
		// List<Integer> urn = new ArrayList<Integer>();
		//
		// /* Fill urn with balls */
		// Random random = new Random();
		// for (int i = 0; i < 7; i++) {
		// for (int j = 0; j < 10; j++) {
		// urn.add(i);
		// }
		// }
		//
		// List<Integer> balls = urn.subList(0, 20);
		//
		// for (int i = 0; i < 20; i++) {
		// int selection = random.nextInt(70);
		// balls.add(urn.get(selection));
		// //urn.remove(selection);
		// }
		//
		// // int count = 0;
		// for (int i = 0; i < 7; i++) {
		// if (Collections.frequency(balls, i) != 0) {
		// // count++;
		// c++;
		// }
		// }
		// }
		System.out.println(c);
		System.out.println(c / runs);
		System.out.println(c / runs / 20);
		uptime();
	}

}
