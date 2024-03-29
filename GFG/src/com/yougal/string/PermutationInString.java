package com.yougal.string;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * 
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo" 
 * 
 * Output: true 
 * 
 * Explanation: s2 contains one permutation of s1 ("ba"). 
 * 
 * Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo" 
 * 
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, 
 * s2.length <= 104 
 * s1 and s2 consist of lowercase English
 * letters.
 * 
 * 
 * @author yougal.bisht
 *
 */
public class PermutationInString {
	
	public static void main(String[] args) {
		PermutationInString permutationInString=new PermutationInString();
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(permutationInString.checkInclusion(s1, s2));
	}
	
	
	public boolean checkInclusion(String s1, String s2) {
		int [] ar = new int[256];
		s1.chars().forEach(f->ar[f-'a']++);
		int [] curr = new int[256];
		int i=0;
		for(;i<s1.length()&&i<s2.length();i++) {
			curr[s2.charAt(i)-'a']++;
		}
		boolean found = isFound(curr,ar);
		while(!found && i<s2.length()) {
			curr[s2.charAt(i)-'a']++;
			curr[s2.charAt(i-s1.length())-'a']--;
			found = isFound(curr,ar);
			i++;
		}
		return found;   
    }


	private boolean isFound(int[] curr, int[] ar) {
		for(int i=0;i<256;i++) {
			if(curr[i]!=ar[i]) {
				return false;
			}
		}
		return true;
	}

}
