package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem045 extends RT {

	/*
	 * https://projecteuler.net/problem=45 It can be verified that T285 = P165 =
	 * H143 = 40755.
	 * 
	 * Find the next triangle number that is also pentagonal and hexagonal.
	 * 
	 * Program took 172 milliseconds :/
	 */
	public static void main(final String[] args) {
		long MAX = 100000;
		Set<Long> triangles = new HashSet<Long>();
		Set<Long> pentagons = new HashSet<Long>();
		Set<Long> hexagons = new HashSet<Long>();

		for (long i = 1; i <= MAX; i++) {
			triangles.add(getTriangle(i));
			pentagons.add(getPentagonal(i));
			hexagons.add(getHexagonal(i));
		}

		// int count = 0;
		
		triangles.retainAll(pentagons);
		triangles.retainAll(hexagons);
		Utils.printList(triangles);
		// for(long i : triangles) {
		//
		// if(pentagons.contains(i) && hexagons.contains(i)) {
		// count++;
		// System.out.println(i);
		// if(count == 3) {
		// break;
		// }
		// }
		// }

		uptime();
	}

	private static long getTriangle(long i) {
		return (i * (i + 1)) / 2;
	}

	private static long getPentagonal(long i) {
		return (i * (3 * i - 1)) / 2;
	}

	private static long getHexagonal(long i) {
		return i * (2 * i - 1);
	}
}
