package io.github.Skepter.ForeignProblems;

import io.github.Skepter.Utils.RT;

public class Problem039 extends RT {

	/* Solution by paddington1 */
	
	public static void main(String Arg[]) {
		int theMost = 0;
		for (int p = 120; p < 1000; p++) {
			int counter = 0;
			for (int a = 1; a < p; a++)
				/** b has to be less than a */
				for (int b = 1; b < a; b++) { 
					/** c doesn't have to be calculated using a loop, use p to check if c fits the triangle */
					int c = p - a - b;
					if (a * a + b * b == c * c)
						counter++;
				}
			if (counter > theMost) {
				theMost = counter;
				System.out.println("p=" + p + " generates " + counter + " triangles");
			}
		}
		uptime();
	}

}