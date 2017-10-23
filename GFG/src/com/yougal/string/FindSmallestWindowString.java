package com.yougal.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * Given a string and text output the smallest window in the string which covers all the 
 * characters present in the text. Both the string and text contains small case letters. 
 * If such window doesn't exist or this task can not be done then print -1. 
 * 
 * Input: First line contains T , 
 * 		  the number of test cases and each test contains 2 lines having a string each 
 * 		  and  ( n is the main string and x is the text ) 
 * 
 * Output: Output the smallest window of the string containing all the characters of the text. 
 * 
 * Constraints: 1<=N,X<=1000 
 * 
 * Example: 
 * 
 * Input: 
 * 			2 
 * 			timetopractice 
 * 			toc 
 * 			zoomlazapzo 
 * 			oza
 * 
 * Output:
 * 			toprac
 * 			apzo
 * 
 * @author yougal.bisht
 *
 */
public class FindSmallestWindowString {
	public static void main(String[] args) {
		
		/**Scanner sc = new Scanner(System.in);
		int numberOfInput  = Integer.valueOf(sc.nextLine());
		String patterns[][][] = new String[numberOfInput][1][2];
		int i=0;
		while (sc.hasNext()) {
			String mainString = sc.next();
			patterns[i][0][0] = mainString;
			String pattern = sc.next();
			patterns[i][0][1] = pattern;
			i++;
		}
		for (i = 0; i < patterns.length; i++) {
			String input[][] = patterns[i];
			String mainString = input[0][0];
			String text = input[0][1];
			Map<String, Long> patternData = Arrays.stream(text.toLowerCase().split("")).
					collect(Collectors.groupingBy(f->f,Collectors.counting()));
			Index result = findsmallestWindowOfStringEfficient(mainString,patternData);
			System.out.println(result);
		}
		meelfpjsftgftovlepaykfcqphlctjechoxjttvxpfcaauslepcxfumzzfpbsgqxjhegknhdhby
		sc.close();**/
		
		String mainString = "meelfpjsftgftovlepaykfcqphlctjechoxjttvxpfcaauslepcxfumzzfpbsgqxjhegknhdhby"
						  + "mgclgjxifogxtrsolkgrskfippxodbokgbthayqhwdxwtkjlqbnmy"
						  + "yxmgydirkkrfbzdpngylezeiiipzohvipctunskwdrvrfeihyrqwpguanhpfhvtwxhdaouydzxbwhlniweuwoezwcfoi"
				+ "cjessqbmbjxgprofesfoozdqpjcszkwdyhlpvtqvesfctsrpsourkeowebwjxizojhzya"
				+ "mcvgtfksejtindwhkypuelynuvwyihfsxbfppyakhjolhumltgbjdyqjtxqkhunqacuwsfcdjcm"
				+ "lfvuuzmbcppxapxcpawrutqpkavntdtlhhbscrheyxrzlunpefydwhrczwjc";
		String text = "cfoybjlynmm";
		//correct: yakhjolhumltgbjdyqjtxqkhunqacuwsfcdjcm
		//my output: mcvgtfksejtindwhkypuelynuvwyihfsxbfppyakhjolhum
		Index result = findsmallestWindowOfStringEfficient(mainString, text);
		System.out.println(result);
	}
	
	private static Index findsmallestWindowOfStringEfficient(String mainString,String text) {
		/*
		 * what we will do is to 
		 * 
		 * first find the string which contains all characters of pattern data
		 * now when we get the string we trim it to get rid of multiple occurrence more than patternData
		 * 
		 *   
		 */
		Map<String, Long> patternData = Arrays.stream(text.toLowerCase().split("")).
				collect(Collectors.groupingBy(f->f,Collectors.counting()));
		Map<String, Long> patternDataTemp = new HashMap<>(patternData);
		Map<String, Long> patternDataInPart = new HashMap<>();
		int start =0;
		Index index =null;
		int i = 0;
		int firstStart = Integer.MAX_VALUE;
		for (i = 0; i < mainString.length(); i++) {
			
			if(patternDataTemp.isEmpty()){
				
			/*	while(mainString.charAt(i) == mainString.charAt(i-1)){
					patternDataInPart.computeIfAbsent(String.valueOf(mainString.charAt(i)), k->0l);
					patternDataInPart.computeIfPresent(String.valueOf(mainString.charAt(i)), (k,oldValue)->oldValue+1);
					i++;
				}*/
				
				//trim extra characters to find smallest window
				//compare to current smallest window
				
				while(start<i){
					String indexCharacter = String.valueOf(mainString.charAt(start));
					if(!patternData.containsKey(indexCharacter)){
						start++;
					}else{
						if(patternDataInPart.get(indexCharacter)>patternData.get(indexCharacter)){
							start++;
							patternDataInPart.put(indexCharacter, patternDataInPart.get(indexCharacter)-1);
						}else{
							break;
						}
					}
					
				}
				Index indexNew = new Index(start, i, mainString);
				if(index==null){
					index= indexNew;
				}else{
					if(index.compareTo(indexNew)>1){
						index = indexNew;
					}
				}
				patternDataTemp = new HashMap<>(patternData);
				patternDataInPart.clear();
				start=i;
				firstStart=Integer.MAX_VALUE;
				i=i-1;
			}else{
				if(index!=null && index.length()<i-start+1){
					patternDataTemp = new HashMap<>(patternData);
					patternDataInPart.clear();
					start=firstStart;
					i=firstStart;
					firstStart=Integer.MAX_VALUE;
					continue;
				}
				String indexCharacter = String.valueOf(mainString.charAt(i));
				if(patternData.containsKey(indexCharacter)){
					patternDataInPart.computeIfAbsent(indexCharacter, k->0l);
					patternDataInPart.computeIfPresent(indexCharacter, (k,oldValue)->oldValue+1);
				}
				if(patternDataTemp.containsKey(indexCharacter)){
					if(patternDataTemp.get(indexCharacter)>1){
						patternDataTemp.put(indexCharacter, patternDataTemp.get(indexCharacter)-1);
					}else{
						patternDataTemp.remove(indexCharacter);	
					}
					if(firstStart>i){
						firstStart=i;	
					}
				}
			}
			
			
		}
		if(patternDataTemp.isEmpty()){
			
			//trim extra characters to find smallest window
			//compare to current smallest window
			
			while(start<i){
				String indexCharacter = String.valueOf(mainString.charAt(start));
				if(!patternData.containsKey(indexCharacter)){
					start++;
				}else{
					if(patternDataInPart.get(indexCharacter)>patternData.get(indexCharacter)){
						patternDataInPart.put(indexCharacter, patternDataInPart.get(indexCharacter)-1);
						start++;
					}else{
						break;
					}
				}
				
			}
			Index indexNew = new Index(start, i, mainString);
			if(index==null){
				index= indexNew;
			}else{
				if(index.compareTo(indexNew)>1){
					index = indexNew;
				}
			}
		}
		return index;
		
	}
	
	private static class Index implements Comparable<Index>{
		private int startIndex;
		private int endIndex;
		private String pattern;
		public Index(int startIndex, int endIndex, String pattern) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.pattern=pattern;
		}
		@Override
		public int compareTo(Index o) {
			return (this.endIndex-this.startIndex) - (o.endIndex-o.startIndex);
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return pattern.substring(startIndex,endIndex);
		}
		public int length(){
			return endIndex-startIndex+1;
		}
		
	}
}
