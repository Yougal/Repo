package com.yougal.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	
	 public int lengthOfLongestSubstring(String s) {
	        Map<Character,Integer> startingIndex = new HashMap<Character,Integer>();
	        int startIndex=0;
	        int maxLength=0;
	        char a[] = s.toCharArray();
	        for(int i=0;i<a.length;i++){
	            if(startingIndex.containsKey(a[i])){
	               if(startIndex<startingIndex.get(a[i])) {
	            	   startIndex=startingIndex.get(a[i]);
	               }
	               startingIndex.put(a[i],i+1); 
	            }
	            startingIndex.put(a[i],i+1);
	            maxLength=Math.max(maxLength,i-startIndex+1);
	        }
	        return maxLength;
	    }
	 
	 public static void main(String[] args) {
		LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
		System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
		
	}
}
