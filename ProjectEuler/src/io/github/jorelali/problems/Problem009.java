package io.github.jorelali.problems;
public class Problem009 {

	/*
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

	a2 + b2 = c2
	For example, 32 + 42 = 9 + 16 = 25 = 5^2.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.
	 */
	public static void main(final String[] args) {
		final int x = 1000;
		for (int i = 1; i < (x + 1); i++)
			for (int j = 1; j < (x + 1); j++)
				for (int z = 0; z < x; z++) {
					final int k = j + z;
					if ((((i * i) + (j * j)) == (k * k)) && (i < j))
						if ((i + j + k) == x)
							//							System.out.println("A: " + i + " B: " + j + " C: " + k);
//							System.out.println("A^2: " + i * i + " B^2: " + j * j + " C^2: " + k * k);
							System.out.println(i * j * k);
				}

	}
}
