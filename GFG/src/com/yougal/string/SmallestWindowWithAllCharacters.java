package com.yougal.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestWindowWithAllCharacters {
	
	public static void main(String[] args) {
		String s = "iymmyalcyeasvxggfitknygyvjxnspubqjppjbrlhugesmmxwjjlkrmgbnwvftyveolprfdcajiuywtvgfj";
		findMinLength(s);
	}
	

	private static void findMinLength(String s) {
		char[] str = s.toCharArray();
		Set<Character> uniqueCharSet = new HashSet<>();
		for (char c : str) {
			uniqueCharSet.add(c);
		}
		Set<Character> uniqueChars = new HashSet<>();
		Map<Character,Integer> countChars = new HashMap<>();
		int startIndex=0;
		Range minRange = new Range(startIndex, str.length-1); 
		for(int i=0;i<str.length;i++) {
			countChars.put(str[i], countChars.getOrDefault(str[i], 0)+1);
			uniqueChars.add(str[i]);
			if(uniqueChars.size()==uniqueCharSet.size()){
				for (int j = startIndex; j <=i ; j++) {
					if(countChars.get(str[j])==1) {
						uniqueChars.remove(str[j]);
						Range newRange = new Range(j, i);
						minRange = newRange.compareTo(minRange)>0?minRange:newRange;
						startIndex=j;
						break;
					}else {
						countChars.put(str[j], countChars.get(str[j])-1);
						
					}
				}
			}
		}
		String substring = s.substring(minRange.startIndex, minRange.endIndex+1);
		System.out.println("Range: " + substring + ", size: "+ substring.length());
		
	}

	private static class Range implements Comparable<Range>{
		int startIndex;
		int endIndex;
		int size;
		public Range(int startIndex, int endIndex) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.size= endIndex-startIndex+1;
		}
		
		@Override
		public int compareTo(Range o) {
			return this.size-o.size;
		}
		
	}

}
