package io.github.skepter.problems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem059 extends RT {

	public static boolean isLetter(int character) {
		return (character >= 65 && character <= 90) || (character >= 97 && character <= 122); 
	}
	
	/*
	 * https://projecteuler.net/problem=59
	 * 
	 * If the password is shorter than the message, which is likely, the key is
	 * repeated cyclically throughout the message. The balance for this method
	 * is using a sufficiently long password key for security, but short enough
	 * to be memorable.
	 * 
	 * the encryption key consists of three lower case characters. Using
	 * cipher.txt, a file containing the encrypted ASCII codes, and the
	 * knowledge that the plain text must contain common English words, decrypt
	 * the message and find the sum of the ASCII values in the original text
	 */
	public static void main(final String[] args) throws Exception {
		assert ((5 ^ 6) == 3);
		Utils.outputToFile("problem59OUT.txt");
		
		String[] arr = Utils.readFromFile("p059_cipher.txt").get(0).split(",");
		String[] arrOriginal = Arrays.copyOf(arr, arr.length);
		Map<String, Integer> occurrence = new HashMap<String, Integer>();
		for (String str : arr) {
			occurrence.put(str, occurrence.getOrDefault(str, 0) + 1);
		}
		
		System.out.println(Arrays.toString(arr));
		
		/*
		 * Strategy:
		 * Find the possible 3 characters for the first, second and third character
		 * for the encryption key. The result when xored must be a letter (either upper or lower case)
		 */
		
		//Lists containing the possible 1st, 2nd and 3rd character
		Set<Integer> chars1 = new HashSet<Integer>();
		Set<Integer> chars2 = new HashSet<Integer>();
		Set<Integer> chars3 = new HashSet<Integer>();
		
		//Sets of all of the numbers from the ciphertext (since it loops cyclically)
		Set<Integer> arr1 = new HashSet<Integer>();
		Set<Integer> arr2 = new HashSet<Integer>();
		Set<Integer> arr3 = new HashSet<Integer>();
		
		//Populate sets above
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			if(i % 3 == 0) {
				arr1.add(Integer.parseInt(str));
			} else if(i % 3 == 1) {
				arr2.add(Integer.parseInt(str));
			}  else if(i % 3 == 2) {
				arr3.add(Integer.parseInt(str));
			} else {
				throw new Exception("This shouldn't occur");
			}
		}
		
		Utils.printListSingleLine(arr1);
		
		for(int i = 0; i < 128; i++) {
			if(i >= 65 && i <= 90) {
				continue;
			}
			//First letter
			boolean isLetter = false;
			for(int c : arr1) {
				if(isLetter(c ^ i)) {
					isLetter = true;
				} else {
					isLetter = false;
				}
			}
			if(isLetter) {
				chars1.add(i);
			}

			//Second letter
			isLetter = false;
			for(int c : arr2) {
				if(isLetter(c ^ i)) {
					isLetter = true;
				} else {
					isLetter = false;
				}
			}
			if(isLetter) {
				chars2.add(i);
			}
			
			//Third letter
			isLetter = false;
			for(int c : arr3) {
				if(isLetter(c ^ i)) {
					isLetter = true;
				} else {
					isLetter = false;
				}
			}
			if(isLetter) {
				chars3.add(i);
			}
		}
		
		//Number of permutations (30720)
		System.out.println(chars1.size() * chars2.size() * chars3.size());
		
		Utils.printListSingleLine(chars1);
		Utils.printListSingleLine(chars2);
		Utils.printListSingleLine(chars3);
		
		uptime();
		
		
		for(int c1 : chars1) {
			for(int c2 : chars2) {
				for(int c3 : chars3) {
					for (int i = 0; i < arrOriginal.length; i++) {
						String str = arrOriginal[i];
						if(i % 3 == 0) {
							arr[i] = String.valueOf((char)(Integer.parseInt(str) ^ c1));
						} else if(i % 3 == 1) {
							arr[i] = String.valueOf((char)(Integer.parseInt(str) ^ c2));
						}  else if(i % 3 == 2) {
							arr[i] = String.valueOf((char)(Integer.parseInt(str) ^ c3));
						} else {
							throw new Exception("This shouldn't occur");
						}
					}
					System.out.println(Arrays.deepToString(arr));
				}
			}
		}
		
		
		
		
		
		
		
		
		
//		//Utils.printMap(occurrence);
//
//		/*
//		 * 44: 2 45: 4 89: 1 48: 1 91: 1 92: 1 93: 1 94: 1 52: 1 10: 60 11: 54
//		 * 12: 31 56: 2 13: 24 14: 38 59: 4 15: 26 16: 38 17: 9 18: 10 19: 35 0:
//		 * 49 1: 63 2: 60 3: 37 4: 5 5: 21 6: 49 7: 41 8: 34 9: 41 60: 1 20: 22
//		 * 64: 1 21: 15 65: 2 22: 22 67: 2 23: 17 68: 77 24: 9 25: 6 69: 1 26: 6
//		 * 27: 21 28: 21 29: 11 71: 70 72: 5 73: 11 30: 4 74: 4 31: 4 75: 5 32:
//		 * 4 33: 2 78: 1 79: 86 35: 3 37: 2 38: 2 39: 2 81: 1 83: 2 40: 1 84: 1
//		 * 85: 5 41: 1 86: 4 87: 3
//		 */
//		
//		//79: 86 occurances. => 79 is probably the letter e = ASCII 101.
//
//		//System.out.println(Character.valueOf((char) 79)); // O need to convert
//															// to 101.
//
//		// 79 XOR a = 101
////		for (int i = 0; i < 100; i++) {
////			if ((79 ^ i) == 101) {
////				System.out.println(i); // 42
////				break;
////			}
////		}
//		
////		System.out.println(0 % 3); -> 0
////		System.out.println(1 % 3); -> 1
////		System.out.println(2 % 3); -> 2
////		System.out.println(3 % 3); -> 0
//
//		//the encryption key consists of three lower case characters.
//		//NOT NECESSARILY LETTERS
//		
//		/*knowledge that the plain text must contain common English words*/
//		
//		/* Using assumption that char1 is between 33 and 46 OR 53 and 63 (due to the result being a letter) */
////		List<Integer> chars1 = new ArrayList<Integer>();
////		for(int i = 33; i <= 46; i++) 
////			chars1.add(i);
////		for(int i = 53; i <= 63; i++) 
////			chars1.add(i);
////		
////		/*
////		 * 92, 93, 94, 95 OR 97, 98, 99 OR 104-122 OR 124 - 126.
////		 * MOST LIKELY to be 92-95
////		 */
////		List<Integer> chars2 = new ArrayList<Integer>();
////		for(int i = 92; i <= 95; i++) 
////			chars2.add(i);
////		for(int i = 97; i <= 99; i++) 
////			chars2.add(i);
////		for(int i = 104; i <= 122; i++) 
////			chars2.add(i);
////		for(int i = 124; i <= 126; i++) 
////			chars2.add(i);
////		
////		/*
////		 * Char3 can be: 64 OR 91-107 OR 109-111 OR 116-118 OR 120-126
////		 */
////		List<Integer> chars3 = new ArrayList<Integer>();
////		chars3.add(64);
////		for(int i = 91; i <= 107; i++) 
////			chars3.add(i);
////		for(int i = 109; i <= 111; i++) 
////			chars3.add(i);
////		for(int i = 116; i <= 118; i++) 
////			chars3.add(i);
////		for(int i = 120; i <= 126; i++) 
////			chars3.add(i);
//		
//		//Generic lists of characters NON-CAPS:
//		List<Integer> chars1 = new ArrayList<Integer>();
//		List<Integer> chars2 = new ArrayList<Integer>();
//		List<Integer> chars3 = new ArrayList<Integer>();
//		for(int i = 33; i < 127; i++) {
//			if(i >= 65 && i <= 90)
//				continue;
//			chars1.add(i);
//			chars2.add(i);
//			chars3.add(i);
//		}
//		
//		for(int char1 : chars1) {
//			for(int char2 : chars2) {
//				for(int char3 : chars3) {
//					arr = Arrays.copyOf(arrOriginal, arrOriginal.length);
//					for (int i = 0; i < arrOriginal.length; i++) {
//						String s = arrOriginal[i];
//
//						int XOR1 = (Integer.parseInt(s) ^ char1);
//						int XOR2 = (Integer.parseInt(s) ^ char2);
//						int XOR3 = (Integer.parseInt(s) ^ char3);
//
//						if(XOR1 < 32 || XOR2 < 32 || XOR3 < 32) 
//							continue;
//
//						if(i % 3 == 0) {
//							arr[i] = String.valueOf((char) XOR1); 
//						} else if(i % 3 == 1) {
//							arr[i] = String.valueOf((char) XOR2);
//						} else if(i % 3 == 2) {
//							arr[i] = String.valueOf((char) XOR3);
//						}
//					}
//					System.out.println(Arrays.toString(arr));
//				}
//			}
//		}

		
		
		
		
		
		
		
//		/* Using assumption that char1 is between 33 and 46 OR 53 and 63 (due to the result being a letter) */
//		for(int char1 = 33; char1 <= 63; char1++) {
//			
//			//
//			
//			
//			//Ignore uppercase letters
//			if(char1 >= 47 && char1 <= 52) {
//				continue;
//			}
//			/* Checking the first character 79 */
//			System.out.println(char1 + ": " + (char)(79 ^ char1));
//			
////			for(int char2 = 33; char2 <= 63; char2++) {
////				
////				if(char2 >= 47 && char2 <= 52) {
////					continue;
////				}
////				
////				for(int char3 = 33; char3 <= 63; char3++) {
////					
////					if(char3 >= 47 && char3 <= 52) {
////						continue;
////					}
////					
////					for (int i = 0; i < arr.length; i++) {
////						String s = arrOriginal[i];
////						if(i % 3 == 0) {
////							arr[i] = String.valueOf((char) (Integer.parseInt(s) ^ char1)); 
////						} else if(i % 3 == 1) {
////							arr[i] = String.valueOf((char) (Integer.parseInt(s) ^ char2));
////						} else if(i % 3 == 2) {
////							arr[i] = String.valueOf((char) (Integer.parseInt(s) ^ char3));
////						}
////					}
////					System.out.println(Arrays.toString(arr));
////				}
////			}
//		}
//		
//		System.out.println("Checking char2");
//		
//		/* Char2 can be: 92, 93, 94, 95 OR 97, 98, 99 OR 104-122 OR 124 - 125.
//		 * MOST LIKELY to be 92-95 */
//		for(int char2 = 33; char2 <= 126; char2++) {
//			//Ignore uppercase letters
//			if(char2 >= 65 && char2 <= 90) {
//				continue;
//			}
//			/* Checking the first character 59 */
//			System.out.println(char2 + ": " + (char)(59 ^ char2));
//		}
//		
//		System.out.println("Checking char3");
//
//		/*
//		 * Char3 can be: 64 OR 91-107 OR 109-111 OR 116-118 OR 120-126
//		 */
//		for (int char2 = 33; char2 <= 126; char2++) {
//			// Ignore uppercase letters
//			if (char2 >= 65 && char2 <= 90) {
//				continue;
//			}
//			/* Checking the first character 12 */
//			System.out.println(char2 + ": " + (char) (12 ^ char2));
//		}
//		
////		for (int c = 0; c <= 10000; c++) {
////			for (int i = 0; i < arr.length; i++) {
////				String str = arr[i];
////				if ((Integer.parseInt(str) ^ c) < 32) {
////					continue;
////				}
////				arr[i] = String.valueOf((char) (Integer.parseInt(str) ^ c));
////			}
////
////			System.out.println(Arrays.toString(arr));
////			arr = Arrays.copyOf(arrOriginal, arrOriginal.length);
////		}

		uptime();
	}
}
