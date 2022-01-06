package com.yougal.string;

public class RepeatStringMatch {
	static int repeatedStringMatch(String A, String B) {
		int  result=1;
		String S=A;
		while(S.length()<B.length()) {
			S+=A;
			result++;
		}
		if(isSubString(B, S)) {
			return result;
		}
		if(isSubString(B, S+A)) {
			result++;
			return result;
		}
		return -1;
		
	} 
	
	static boolean isSubString(String pattern, String text){
		int p=pattern.length();
		int t=text.length();
		for(int i=0;i<=t-p;i++) {
			int j=0;
			for(;j<p;j++) {
				if(pattern.charAt(j)!=text.charAt(i+j)) {
					break;
				}
			}
			if(j==p) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
	}
}
