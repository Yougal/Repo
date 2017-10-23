package com.yougal.dp;
/**
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
 * @author yougal.bisht
 *
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 *
 */
public class EditDistance {

	public static void main(String[] args) {
	    String str1 = "saturday";
	    String str2 = "sunday";
	 
	    System.out.println(editDist(str1 , str2 , str1.length(), str2.length()));

	}

	private static int editDist(String str1, String str2, int m, int n) {
		
		int result[][]= new int[n+1][m+1];
		for(int i=0;i<=m;i++){
			result[0][i]=i;
		}
		for(int i=0;i<=n;i++){
			result[i][0]=i;
		}
		
		for(int i=1;i<=n;i++){
			
			for(int j=1;j<=m;j++){
				
				if(str1.charAt(j-1) == str2.charAt(i-1)){
					result[i][j]=result[i-1][j-1];
				}else{
					result[i][j]=1+ Math.min(Math.min(result[i-1][j-1], result[i-1][j]),result[i][j-1]);
				}
			}
		}
		
		return result[n][m];
		
	}
	
	
}
