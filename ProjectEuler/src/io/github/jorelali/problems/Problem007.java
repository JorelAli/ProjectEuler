package io.github.jorelali.problems;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem007 extends RT{

	//What is the 10001st prime number?
	//Program took 094 milliseconds
	public static void main(final String[] args) {
		//Zero indexed, so 10001 - 1
		System.out.println(SieveWithBitset.sieveOfEratosthenes(500000).get(10001 - 1));
		uptime();
	}
}
