package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem045 extends RT {

	/*
	 * https://projecteuler.net/problem=45 It can be verified that T285 = P165 =
	 * H143 = 40755.
	 * 
	 * Find the next triangle number that is also pentagonal and hexagonal.
	 * 
	 * Program took 01 minutes, 26 seconds, 892 milliseconds :/
	 */
	public static void main(final String[] args) {
		long MAX = 100000;
		List<Long> triangles = new ArrayList<Long>();
		List<Long> pentagons = new ArrayList<Long>();
		List<Long> hexagons = new ArrayList<Long>();
		
		for(long i = 1; i <= MAX; i++) {
			triangles.add(getTriangle(i));
			pentagons.add(getPentagonal(i));
			hexagons.add(getHexagonal(i));
		}
	
		//int count = 0;
		List<Long> triangles2 = new ArrayList<Long>();
		triangles2.addAll(triangles);
		System.out.println("Removing pentagons");
		triangles.removeAll(pentagons);
		System.out.println("Updating triangles");
		triangles2.removeAll(triangles);
		System.out.println("Removing hexagons");
		triangles.removeAll(hexagons);
		Utils.printList(triangles2);
//		for(long i : triangles) {
//			
//			if(pentagons.contains(i) && hexagons.contains(i)) {
//				count++;
//				System.out.println(i);	
//				if(count == 3) {
//					break;
//				}
//			}
//		}
		
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
