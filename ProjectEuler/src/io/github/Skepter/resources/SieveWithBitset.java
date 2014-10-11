package io.github.Skepter.resources;

import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;

public class SieveWithBitset {
	private BitSet sieve;

	public SieveWithBitset(int size) {
		sieve = new BitSet((size + 1) / 2);
	}

	public boolean isComposite(int k) {
		assert k >= 3 && (k % 2) == 1;
		return sieve.get((k - 3) / 2);
	}

	public void setComposite(int k) {
		assert k >= 3 && (k % 2) == 1;
		sieve.set((k - 3) / 2);
	}

	public static List<Integer> sieveOfEratosthenes(int max) {
		SieveWithBitset sieve = new SieveWithBitset(max + 1); // +1 to include max itself
		for (int i = 3; i * i <= max; i += 2) {
			if (sieve.isComposite(i))
				continue;

			// We increment by 2*i to skip even multiples of i
			for (int multiplei = i * i; multiplei <= max; multiplei += 2 * i)
				sieve.setComposite(multiplei);
		}

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i <= max; i += 2)
			if (!sieve.isComposite(i))
				primes.add(i);
		return primes;
	}
}