package com.yougal.string;
/**
 * 
 * 
 * https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/
 * 
 * 
 * Check if strings are rotations of each other or not | Set 2
	Given two strings s1 and s2, check whether s2 is a rotation of s1.
	
	Examples:
	
	Input : ABACD, CDABA
	Output : True
	
	Input : GEEKS, EKSGE
	Output : True
 * 
 * @author yougal.bisht
 *
 */
public class CheckTwoStringOneRotatedAreSame {
	
	public static boolean isRotation(String a, String b) {
		int n = a.length();
		int m = b.length();
		if (n != m)
			return false;

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lps[] = new int[n];

		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to n-1
		while (i < n) {
			if (a.charAt(i) == b.charAt(len)) {
				lps[i] = ++len;
				++i;
			} else {
				if (len == 0) {
					lps[i] = 0;
					++i;
				} else {
					len = lps[len - 1];
				}
			}
		}

		i = 0;

		// match from that rotating point
		for (int k = lps[n - 1]; k < m; ++k) {
			if (b.charAt(k) != a.charAt(i++))
				return false;
		}
		return true;
	}

	// Driver code
	public static void main(String[] args) {
		String s1 = "ABACD";
		String s2 = "CDABA";

		System.out.println(isRotation(s1, s2) ? "1" : "0");
	}
}
