package com.yougal.string;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * https://www.geeksforgeeks.org/partition-given-string-manner-ith-substring-sum-1th-2th-substring/
 * 
 * 
 * @author yougal.bisht
 *
 */
public class PartitionString {

	static List<Integer> resultList =  new LinkedList<>();
	
	
	public static void main(String[] args) {
	    String numStr = "11235813";
	    checkCorrected(numStr,1,1);
	    System.out.println(resultList);
	    resultList.clear();
	    
	    numStr = "1111223";
	    checkCorrected(numStr,1,1);
	    System.out.println(resultList);
	    resultList.clear();
	    
	    numStr = "1111213";
	    checkCorrected(numStr,1,1);
	    System.out.println(resultList);
	    resultList.clear();
	    
	    numStr = "11121114";
	    checkCorrected(numStr,1,1);
	    System.out.println(resultList);
	    resultList.clear();
	}
	
	public static boolean checkCorrected(String numStr,int firstOff, int secOff) {
		if(numStr.length()==0) {
			return false;
		}
		int first = Integer.valueOf(numStr.substring(0, firstOff));
		int second = Integer.valueOf(numStr.substring(firstOff, firstOff+secOff));
		boolean thirdPresent = search(numStr.substring(firstOff+secOff, numStr.length()), first+second);
		if(thirdPresent) {
			String remainingString = numStr.substring(firstOff);
			int thirdOffset = String.valueOf(first+second).length();
			if(remainingString.length()==secOff + thirdOffset) {
				resultList.add(0,first+second);
				resultList.add(0,second);
				resultList.add(0,first);
				return true;
			}else {
				boolean result = checkCorrected(remainingString, secOff, thirdOffset);
				if(result) {
					resultList.add(0,first);
				}else {
					resultList.clear();
				}
				return result;
			}
		}else {
			boolean result = false;
			for(int i =firstOff;i<=numStr.length();i++) {
				for(int j = secOff ;j<=numStr.length()-i;j++) {
					if(i!=firstOff || j!=secOff) {
						result = checkCorrected(numStr, i, j);
						 if(result) {
							 return result;
						 }
					}
				}
			}
			return result;
		}
	}
	
	
	private static boolean search(String str, int third) {
		int numDigitsInThird = String.valueOf(third).length();
		if(numDigitsInThird<=str.length()) {
			int valueOfThirdInString = Integer.valueOf(str.substring(0, numDigitsInThird));
			return third==valueOfThirdInString;
		}
		return false;
	}

	public static List<Integer> check(String numStr) {
		List<Integer> result =  new LinkedList<>();
		for(int start=0;start<numStr.length();start++) {
			int prevSec = -1, prevThird=-1;
			for(int firstOff =1;firstOff<=numStr.length()-start;firstOff++) {
				for(int secOff = 1 ; secOff<=numStr.length()-firstOff-start;secOff++) {
					int first = Integer.valueOf(numStr.substring(start, start+firstOff));
					int second = Integer.valueOf(numStr.substring(start+firstOff, start+firstOff+secOff));
					int third = first + second;
					int numDigitsInThird = String.valueOf(third).length();
					if(start+firstOff+secOff+numDigitsInThird<=numStr.length()) {
						int valueOfThirdInString = Integer.valueOf(numStr.substring(start+firstOff+secOff, start+firstOff+secOff+numDigitsInThird));
						if(valueOfThirdInString==third && ((prevSec==-1 && prevThird==-1) || (prevSec==first && prevThird==second))) {
							if(prevSec==-1 && prevThird==-1) {
								result.add(first);
								result.add(second);
							}
							prevSec=second;
							prevThird=third;
							result.add(third);
							if(start+firstOff+secOff+numDigitsInThird==numStr.length()) {
								return null;
							}
							break;
						}
					}
				
				}
			}
		}
		return result;			
	}
	
}
