package com.yougal.dp;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/remove-array-end-element-maximize-sum-product/
 * 
 * @author yougal.bisht
 *
 */
public class RemoveAndMaximizeProfit {
	
	public static void main(String[] args) {
		    int arr[] = { 1, 3, 1, 5, 2 };
		    int n = arr.length;
		    int dp[][] =  new int[n][n];
		    System.out.println(solve(dp, arr, 0, n - 1, 1));
	}

	private static int solve(int[][] dp, int[] arr, int start, int end, int turn) {
		if (start == end){
	        return arr[start] * turn;
		}else if(dp[start][end]!=0){
			return dp[start][end];
		}else{
			dp[start][end] = Math.max(
					arr[start] * turn + solve(dp, arr, start+1, end, turn+1),
					arr[end] * turn + solve(dp, arr, start, end-1, turn+1)
					);
			return dp[start][end];
		}
		
	}
	
}
