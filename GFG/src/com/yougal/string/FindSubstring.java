package com.yougal.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * @author yougal.bisht
 *
 */
public class FindSubstring {
	
	 public List<Integer> findSubstring(String s, String[] words) {
		 	List<Integer> indexes = new ArrayList<Integer>();
	        Map<String, Long> wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f->f, Collectors.counting()));
	        Set<String> allWords = Arrays.stream(words).collect(Collectors.toSet());
	        int lengthOfEachWord = words[0].length();
	        int startIndex=0;
	        for (int i = 0; (i+lengthOfEachWord)<=s.length(); i+=1) {
				String strChk = s.substring(i, i+lengthOfEachWord); 
				if(allWords.contains(strChk)) {
					if(wrdFreq.containsKey(strChk)) {
						if(wrdFreq.get(strChk)-1<=0) {
							wrdFreq.remove(strChk);
						}else {
							wrdFreq.put(strChk,	wrdFreq.get(strChk)-1);
						}
						i=i+lengthOfEachWord-1;
					}else {
						i=startIndex;
						startIndex=i+1;
						wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f->f, Collectors.counting()));
					}
					if(wrdFreq.isEmpty()) {
						indexes.add(startIndex);
						i=startIndex;
						startIndex+=1;
						wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f->f, Collectors.counting()));
					}
				}else {
					i=startIndex;
					startIndex+=1;
					wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f->f, Collectors.counting()));
				}
			}
				
	        return indexes;
	    }
	 
	 public static void main(String[] args) {
		 FindSubstring findSubstring = new FindSubstring();
		 System.out.println(findSubstring.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",new String[] {"fooo","barr","wing","ding","wing"}));
		 System.out.println(findSubstring.findSubstring("barfoothefoobarman",new String[] { "foo","bar"}));
		 System.out.println(findSubstring.findSubstring("barfoofoobarthefoobarman",new String[] { "bar","foo","the"}));
		 System.out.println(findSubstring.findSubstring("aaaaaaaaaaaaaa",new String[] { "aa","aa"}));
		 System.out.println(findSubstring.findSubstring("ababaab",new String[] {"ab","ba","ba"}));
		 System.out.println(findSubstring.findSubstring("abaababbaba",new String[] {"ab","ba","ab","ba"}));
		 System.out.println(findSubstring.findSubstring("barfoothefoobarman",new String[] {"foo","bar"}));
	}
}
