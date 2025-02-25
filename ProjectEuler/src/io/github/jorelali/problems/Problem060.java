package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.SimpleGraph;

public class Problem060 extends RT {
	/*
	 * https://projecteuler.net/problem=60
	 * 
	 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes
	 * and concatenating them in any order the result will always be prime. For
	 * example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
	 * four primes, 792, represents the lowest sum for a set of four primes with
	 * this property.
	 * 
	 * Find the lowest sum for a set of five primes for which any two primes
	 * concatenate to produce another prime.
	 */
	public static void main(final String[] args) throws Exception {
		int maxPrimes = 1000;
		int maxPrimeCheck = 1000000;
		List<Integer> primes = SieveWithBitset.getPrimes(maxPrimes);
		Set<Integer> primesSet = SieveWithBitset.getPrimesAsSet(maxPrimeCheck);

		SimpleGraph<Integer> graph = new SimpleGraph<>();
		for (int prime : primes) {
			graph.addNode(prime);
		}

		for (int node : graph.getNodes()) {
			for (int other : graph.getNodes()) {
				// If it isn't myself
				if (other != node) {
					int newVal1 = Integer.parseInt(node + "" + other);
					int newVal2 = Integer.parseInt(other + "" + node);
					if (primesSet.contains(newVal1) && primesSet.contains(newVal2)) {
						graph.connectBothWays(node, other);
					}
				}
			}
		}

		checker:
		for (int node1 : graph.getNodes()) {
			for (int node2 : graph.getNodes()) {
				for (int node3 : graph.getNodes()) {
					for (int node4 : graph.getNodes()) {
						for (int node5 : graph.getNodes()) {
						// If they're all unique
							if (node1 != node2 && node2 != node3 && node3 != node4 && node4 != node5) {
								List<Boolean> checks = List.of(
									graph.isConnectedTo(node1, node2),
									graph.isConnectedTo(node1, node3),
									graph.isConnectedTo(node1, node4),
									graph.isConnectedTo(node1, node5),
									
									graph.isConnectedTo(node2, node3),
									graph.isConnectedTo(node2, node4),
									graph.isConnectedTo(node2, node5),
									
									graph.isConnectedTo(node3, node4),
									graph.isConnectedTo(node3, node5),
									
									graph.isConnectedTo(node4, node5)
								);
								if (checks.stream().allMatch(i -> i)) {
									System.out.println(node1 + " " + node2 + " " + node3 + " " + node4 + " " + node5);
									break checker;
								}
							}
						}
					}
				}
			}
		}

		//System.out.println(graph.getPrettyPrint());

		// We can represent this as a graph. Every prime number is a node, and
		// we can draw an edge between any two nodes if their concatenations (in both
		// orders)
		// are prime numbers. Then, we find a clique of size 5.

		uptime();
	}
}
