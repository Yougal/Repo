package com.yougal.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * @author yougal.bisht
 *
 */
public class MinWindow {

	
	public String minWindow(String s, String t) {
        int lengthOfT = t.length();
        int arr[] = new int[256];
        Arrays.fill(arr, -1);
        
        for(int i=0;i<t.length();i++){
        	if(arr[t.charAt(i)]==-1) {
        		arr[t.charAt(i)]=0;
        	}
        	arr[t.charAt(i)]++;
        }
        
        int arrInTransit[] = new int[256];
        int startIndex=0;
        int minEndIndex= s.length();
        int minStartIndex=-1;
        int i=0;
    	while(i<s.length() && arr[s.charAt(i)]<0) {
    		i++;
    		startIndex=i;
    	}
    	//find first window
    	while(lengthOfT>0  && i<s.length()) {
    		if(arr[s.charAt(i)]>0) {
    			arrInTransit[s.charAt(i)]++;
    			if(arrInTransit[s.charAt(i)]<=arr[s.charAt(i)]) {
    				lengthOfT--;
    			}
    		}
    		i++;
    	}
    	if(lengthOfT<=0) {
	    	startIndex = leftTrim(startIndex,i,s,t,arrInTransit,arr);
	    	if(i-startIndex>=t.length() && lengthOfT<=0) {
	    		if(i-startIndex<minEndIndex-minStartIndex+1) {
	    			minStartIndex=startIndex;
	    			minEndIndex=i-1;
	    		}
			}
	    	int lastIndex=i-1;
	    	while(i<s.length()) {
	    		if(arr[s.charAt(i)]>0) {
	    			arrInTransit[s.charAt(i)]++;
	    			lastIndex=i;
	    		}
	    		startIndex = leftTrim(startIndex,i,s,t,arrInTransit,arr);
	        	if(lastIndex-startIndex+1>=t.length()) {
	        		if(lastIndex-startIndex+1<minEndIndex-minStartIndex+1) {
	        			minStartIndex=startIndex;
	        			minEndIndex=lastIndex;
	        		}
	    		}
	        	i++;
	    	}
	    	startIndex = leftTrim(startIndex,lastIndex,s,t,arrInTransit,arr);
	    	if(lastIndex-startIndex+1>=t.length()) {
	    		if(lastIndex-startIndex+1<minEndIndex-minStartIndex+1) {
	    			minStartIndex=startIndex;
	    			minEndIndex=lastIndex;
	    		}
			}
    	}
    	return minStartIndex!=-1?s.substring(minStartIndex, minEndIndex+1):"";
    }
	
	private int leftTrim(int startIndex, int length,
			String s, String t, 
			int[] arrInTransit, int[] arr) {
		int j=startIndex;
    	while(j<length) {
    		startIndex=j;
    		char charAtJ = s.charAt(j);
			if(arr[charAtJ]>0) {
    			if(arrInTransit[charAtJ]>arr[charAtJ]) {
    				arrInTransit[charAtJ]--;
    			}else {
    				break;
    			}
			}
    		j++;
    	}
    	return startIndex;
	}

	public static void main(String[] args) {
		MinWindow  minWindow = new MinWindow();
		String s = "AADOBECODE", t = "ABC";
		//System.out.println(minWindow.minWindow(s, t));
		s = "ADOBECODEBANC";t = "ABC";
		//System.out.println(minWindow.minWindow(s, t));
		s = "a"; t = "a";
		//System.out.println(minWindow.minWindow(s, t));
		s = "a"; t = "aa";
		//System.out.println(minWindow.minWindow(s, t));
		s ="bbaac";t="aba";
		//System.out.println(minWindow.minWindow(s, t));
		s ="cabefgecdaecf";t="cae";
		//System.out.println(minWindow.minWindow(s, t));
		s ="abbbb";t="aa";
		System.out.println(minWindow.minWindow(s, t));
	}
	
}
