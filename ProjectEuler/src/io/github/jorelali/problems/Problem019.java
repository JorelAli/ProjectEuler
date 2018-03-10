package io.github.jorelali.problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import io.github.jorelali.utils.RT;

public class Problem019 extends RT {

	/* How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)? */

	public static void main(final String[] args) {
		System.out.println(ChronoUnit.MONTHS.between(LocalDate.of(1901, 1, 1), LocalDate.of(2000, 12, 31)) / 7);
		uptime();
	}
}
