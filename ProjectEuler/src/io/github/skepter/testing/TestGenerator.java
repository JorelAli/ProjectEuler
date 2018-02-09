package io.github.skepter.testing;

import java.text.DecimalFormat;

public class TestGenerator {

	public static void main(String[] a) {
		
		String str = "001,002,003,004,005,006,007,008,009,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,034,035,036,037,038,039,040,041,042,043,044,045,046,047,048,049,050,052,053,054,055,056,057,058,059,061,062,063,065,067,069,070,071,072,073,079,080,081,084,089,092,093,094,097,099,100,102,107,112,113,119,145,185,206,230,240,315,345,461,466,487,493,500,504,549,571,587,601";
		
		String[] arr = str.split(",");
		for(String i : arr) {
						System.out.println("@Test(timeout=60000)");
			System.out.println("public void Problem" + i + "() {");
			System.out.println("Problem" + i + ".main(null);");
			System.out.println("}\n");
		}
	}
	
}
