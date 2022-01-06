package com.yougal.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * 438. Find All Anagrams in a String Medium
 * 
 * 
 * Share Given two strings s and p, return an array of all the start indices of
 * p's anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
 * with start index = 0 is "cba", which is an anagram of "abc". The substring
 * with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 * 
 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
 * start index = 0 is "ab", which is an anagram of "ab". The substring with
 * start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, p.length <= 3 * 104 s and p consist of lowercase English
 * letters.
 * 
 * @author yougal.bisht
 *
 */
public class AllAnagrans {

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		AllAnagrans allAnagrans= new AllAnagrans();
		System.out.println(allAnagrans.findAnagrams(s, p));
		s = "abab"; p = "ab";
		System.out.println(allAnagrans.findAnagrams(s, p));
	}

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> result= new ArrayList<Integer>();
		int COUNTS[]= new int[26];
		
		for (int i = 0; i < p.length(); i++) {
			COUNTS[p.charAt(i)-'a']++;
		}
		
		int currentWindow[]= new int[26];
		int l =0;
		for (int i = 0; i < s.length(); i++) {
			currentWindow[s.charAt(i)-'a']++;
			l++;
			if(l==p.length()) {
				if(isValid(currentWindow,COUNTS)) {
					result.add(i-(l-1));
				}
				currentWindow[s.charAt(i-(l-1))-'a']--;
				l--;
			}
		}
		return result;
		
	}

	private boolean isValid(int[] currentWindow, int[] cOUNTS) {
		for (int i = 0; i < 26; i++) {
			if(currentWindow[i]!=cOUNTS[i]) {
				return false;
			}
		}
		return true;
	}
}
