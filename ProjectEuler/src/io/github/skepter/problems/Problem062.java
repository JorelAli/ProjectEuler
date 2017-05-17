package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.skepter.foreignutils.Permutations;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem062 extends RT {

	/**/
	public static void main(final String[] args) {
		Set<Integer> cubes = new HashSet<Integer>();
		int max = 10000;
		for (int i = 0; i <= max; i++) {
			cubes.add(i * i * i);
		}
		for (int i = 0; i <= max; i++) {
			int count = 0;
			for(int cube : cubes) {
				if(Utils.isPermutation(cube, (i*i*i)) && cube != i*i*i) {
					//System.out.println(i*i*i + ": " + cube);
					count++;
				}
			}
			if(count == 5 - 1) {
				System.out.println(i);
			}
			
//			int count = 0;
//			List<String> perms = new ArrayList<String>();
//			for (String str : new Permutations(String.valueOf(i * i * i)).getPermutations()) {
//				if (cubes.contains(Integer.parseInt(str)) && !str.startsWith("0")) {
//					perms.add(str);
//					count++;
//				}
//			}
//			if (count == 5) {
//				Utils.printListSingleLine(perms);
//				continue;
//			}
		}
		uptime();
	}
}
