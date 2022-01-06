package com.yougal.dp;

/**
 * 
 * https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/
 * @author yougal.bisht
 *
 */
public class LongestSubsequenceWithDifference1 {
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 2, 3, 7, 2, 1};
		System.out.println(longestSubsequence(arr));
	}
	
	public static int longestSubsequence(int a[]) {
		int l=a.length;
		int dp[] = new int[l];
		int max = 1;
		for (int i=0;i<l;i++) {
			for(int j=0;j<i;j++) {
				if(a[j]==a[i]-1 || a[j]==a[i]+1) {
					dp[i]=Math.max(dp[i],dp[j]);
				}
			}
			dp[i]+=1;
			max=Math.max(dp[i], max);
		}
		return max;
	}

}
