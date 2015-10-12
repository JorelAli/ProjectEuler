package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Incomplete;
import io.github.Skepter.Utils.RT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem493 extends RT implements Incomplete {

	// 70 colored balls are placed in an urn, 10 for each of the seven rainbow
	// colors.
	//
	// What is the expected number of distinct colors in 20 randomly picked
	// balls?
	//
	// Give your answer with nine digits after the decimal point (a.bcdefghij).

	public static void main(final String[] args) {
		int runs = 100000;
		int c = 0;
		for (int m = 0; m < runs; m++) {
			List<Integer> urn = new ArrayList<Integer>();
			//Wrong. Needs to be 10 of each colour!!!
			Random random = new Random();
			for (int i = 0; i < 70; i++) {
				urn.add(random.nextInt(7));
			}
			List<Integer> balls = urn.subList(0, 20);
			//int count = 0;
			for (int i = 0; i < 7; i++) {
				if (Collections.frequency(balls, i) != 0) {
					//count++;
					c++;
				}
			}
		}
		System.out.println(c / runs);

	}

}
