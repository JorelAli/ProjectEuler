package io.github.jorelali.foreignutils;

import java.util.HashSet;
import java.util.Set;

/* Generates permutations:
 * 
 * http://www.java2s.com/Tutorial/Java/0100__Class-Definition/RecursivemethodtofindallpermutationsofaString.htm
 */
public class Permutations {

	private Set<String> permutations;

	public Permutations(String str) {
		permutations = new HashSet<String>();

		permuteString("", str);
	}

	private void permuteString(String beginningString, String endingString) {

		if (endingString.length() <= 1)
			permutations.add(beginningString + endingString);
		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i) + endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}
	
	public Set<String> getPermutations() {
		return permutations;
	}

}
