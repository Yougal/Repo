package com.yougal.string;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithNoRepeatingChar {

	
	public static void main(String[] args) {
		LongestStringWithNoRepeatingChar longestStringWithNoRepeatingChar =  new LongestStringWithNoRepeatingChar();
		String s="ABDEFGAXYZ";
		longestStringWithNoRepeatingChar.findLength(s);
	}

	private void findLength(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 1;
		int currentLength = 0;
		int currentStartLoc = 0;
		int maxStartLoc=0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indexFound = -1;
			if(map.containsKey(c)){
				indexFound = map.get(c);
			}
			if(indexFound==-1){
				currentLength++;
				map.put(c, i);
			}else{
				currentLength=currentLength-indexFound-1;
				currentStartLoc=indexFound+1;
				map.put(c, i);
			}
		
			
			if(currentLength>maxLength){
				maxStartLoc=currentStartLoc;
				maxLength=currentLength;
			}
		}
		System.out.println(s.substring(maxStartLoc,maxStartLoc+maxLength));
		
	}
	
}
