package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.github.jorelali.utils.RT;

public class Problem002 extends RT {

	//Find sum of all even Fibonacci numbers up to 4 million
	//101ms
	public static void main(final String[] args) {
		final List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(1L);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {

			final long l = (list.get(list.size() - 1) + list.get(list.size() - 2));
			if (l >= 4000000)
				break;
			list.add(l);
		}

		for(final Iterator<Long> i = list.iterator(); i.hasNext(); )
			if ((i.next() % 2) != 0)
				i.remove();

		long count = 0;
		for (final long l : list)
			//System.out.println(l);
			count += l;
		System.out.println(count);
		uptime();
	}
}
