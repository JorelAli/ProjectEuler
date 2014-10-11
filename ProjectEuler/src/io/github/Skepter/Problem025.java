package io.github.Skepter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem025 {

	//What is the first term in the Fibonacci sequence to contain 1000 digits?
	public static void main(String[] args) {
		List<BigInteger> list = new ArrayList<BigInteger>();
		list.add(new BigInteger("1"));
		list.add(new BigInteger("1"));
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			BigInteger bigInteger = list.get(list.size() - 1).add(list.get(list.size() - 2));
			if (bigInteger.toString().length() == 1001)
				break;
			list.add(bigInteger);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ": " + list.get(i).toString().length());
		}
	}
}
