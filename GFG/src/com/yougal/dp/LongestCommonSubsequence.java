package com.yougal.dp;

public class LongestCommonSubsequence {

	
	public static void main(String[] args) {
		char str1[] = "abcdef".toCharArray(); 
		char str2[] = "acbcf".toCharArray();
		LongestCommonSubsequence lcss = new LongestCommonSubsequence();
		int length = lcss.calculateLength(str1,str2);
		System.out.println(length);
	}

	private int calculateLength(char[] str1, char[] str2) {
		int result[][] = new int [str2.length][str1.length];
		int max =-1;
		for(int i=0;i<str2.length;i++){
			for(int j=0;j<str1.length;j++){
				if(str2[i]==str1[j]){
					if(i-1>=0 && j-1>=0){
						result[i][j]=1+result[i-1][j-1];
					}else{
						result[i][j]=1;
					}
				}else{
					if(i-1>=0 ){
						result[i][j] =result[i-1][j];
					}
					if(j-1>=0){
						result[i][j] = Math.max(result[i][j], result[i][j-1]);
					}
					
				}
				max= Math.max(max, result[i][j]);
			}
		}
		return max;
	}
}
