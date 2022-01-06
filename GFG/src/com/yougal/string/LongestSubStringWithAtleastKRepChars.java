package com.yougal.string;

import java.util.Arrays;

/**
 * 
 * 
 *  Longest Substring with At Least K Repeating Characters.
 *  
 *  Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

	Example 1:
	
	Input: s = "aaabb", k = 3
	Output: 3
	Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
	Example 2:e
	
	Input: s = "ababbc", k = 2
	Output: 5
	Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
	 
	
	Constraints:
	
	1 <= s.length <= 104
	s consists of only lowercase English letters.
	1 <= k <= 105
 * @author yougal.bisht
 *
 */
public class LongestSubStringWithAtleastKRepChars {
	
	// Function to find the length of
	// the longest subString
	static void longestSubString(char[] s, int k)
	{

		// Store the required answer
		int ans = 0;

		// Create a frequency map of the
		// characters of the String
		int freq[] = new int[26];

		// Store the length of the String
		int n = s.length;

		// Traverse the String, s
		for (int i = 0; i < n; i++)

			// Increment the frequency of
			// the current character by 1
			freq[s[i] - 'a']++;

		// Stores count of unique characters
		int unique = 0;

		// Find the number of unique
		// characters in String
		for (int i = 0; i < 26; i++)
			if (freq[i] != 0)
				unique++;

		// Iterate in range [1, unique]
		for (int curr_unique = 1;
			curr_unique <= unique;
			curr_unique++)
		{

			// Initialize frequency of all
			// characters as 0
			Arrays.fill(freq, 0);

			// Stores the start and the
			// end of the window
			int start = 0, end = 0;

			// Stores the current number of
			// unique characters and characters
			// occuring atleast K times
			int cnt = 0, count_k = 0;
			while (end < n)
			{
				if (cnt <= curr_unique)
				{
					int ind = s[end] - 'a';

					// New unique character
					if (freq[ind] == 0)
						cnt++;
					freq[ind]++;

					// New character which
					// occurs atleast k times
					if (freq[ind] == k)
						count_k++;

					// Expand window by
					// incrementing end by 1
					end++;
				}
				else
				{
					int ind = s[start] - 'a';

					// Check if this character
					// is present atleast k times
					if (freq[ind] == k)
						count_k--;
					freq[ind]--;

					// Check if this character
					// is unique
					if (freq[ind] == 0)
						cnt--;

					// Shrink the window by
					// incrementing start by 1
					start++;
				}

				// If there are curr_unique
				// characters and each character
				// is atleast k times
				if (cnt == curr_unique
					&& count_k == curr_unique)

					// Update the overall
					// maximum length
					ans = Math.max(ans, end - start);
			}
		}

		// Print the answer
		System.out.print(ans);
	}

	// Driver Code
	public static void main(String[] args){
		String S = "aabbba";
		int K = 3;
		longestSubString(S.toCharArray(), K);
	}

	
	
}
