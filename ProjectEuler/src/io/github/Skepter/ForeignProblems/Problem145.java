package io.github.Skepter.ForeignProblems;

import io.github.Skepter.Utils.RT;

public class Problem145 extends RT {

	/* Solution by paddington1 */
	
	public static void main(String arg[]) {
		int count = 0;
		 
		for (int i = 1; i < 10; i++) {
		 
		    switch (i % 4) {
		        case 0:
		        case 2:
		            count += 20 * (int) Math.pow(30, (i / 2 - 1));
		            break;
		        case 1:
		            count += 100 * (int)Math.pow(500, i / 4 -1);
		            break;
		        case 3:
		            break;
		    }
		 
		}
		System.out.println(count);
		uptime();
	}

}