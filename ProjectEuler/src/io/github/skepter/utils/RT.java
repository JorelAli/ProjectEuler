package io.github.skepter.utils;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
		String time = new SimpleDateFormat("mm:ss:SSS").format(new Date(uptime));
		String formattedTime = time.split(":")[0] + " minutes, " + time.split(":")[1] + " seconds, " + time.split(":")[2] + " milliseconds";
		if(time.split(":")[0].equals("00")) {
			formattedTime = time.split(":")[1] + " seconds, " + time.split(":")[2] + " milliseconds";
		}
		if(time.split(":")[1].equals("00")) {
			formattedTime = time.split(":")[2] + " milliseconds";
		}
		System.out.println("Program took " + formattedTime);
	}
}
