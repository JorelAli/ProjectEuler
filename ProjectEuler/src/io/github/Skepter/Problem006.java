package io.github.Skepter;
public class Problem006 {

	/*
	 * The sum of the squares of the first ten natural numbers is,

	1^2 + 2^2 + ... + 10^2 = 385
	The square of the sum of the first ten natural numbers is,

	(1 + 2 + ... + 10)^2 = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 */
	public static void main(final String[] args) {
		final int size = 100;
		int sumOfSquares = 0;
		for (int i = 1; i <= size; i++)
			sumOfSquares += Math.pow(i, 2);

		int sumSquared = 0;
		for (int i = 1; i <= size; i++)
			sumSquared += i;
		sumSquared = (int) Math.pow(sumSquared, 2);		
		System.out.println(sumSquared - sumOfSquares);
	}
}
