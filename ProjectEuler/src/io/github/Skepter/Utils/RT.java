package io.github.Skepter.Utils;

import java.lang.management.ManagementFactory;

/** Calculates running time of a program */
public class RT {

	static private long before = 0L;

	@Deprecated
	public static void begin() {
		before = System.currentTimeMillis();
	}

	@Deprecated
	public static void end() {
		if (before != 0L)
			System.out.println("Program took " + (System.currentTimeMillis() - before) + "ms");
		else
			System.out.println("Looks like you totally forgot to run begin()!");
	}

	public static void uptime() {
		System.out.println("Program took " + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
	}
}
