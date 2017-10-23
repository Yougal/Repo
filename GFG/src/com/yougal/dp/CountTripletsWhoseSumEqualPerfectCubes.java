package com.yougal.dp;

public class CountTripletsWhoseSumEqualPerfectCubes {

	static int dp[][] = new int [1001][15001];
	
	public static void main(String[] args) {
		 int arr[] = { 2, 5, 1, 20, 6 };
		 System.out.println(countTriplets(arr, arr.length));
		
	}
	
	private static int countTriplets(int[] arr, int n) {
		computeDpArray(arr, arr.length);
		int count =0 ;
		for (int i = 0; i < n-2; i++) {
			for(int j=i+1;j<n-1;j++){
				for(int k=1;k<=24;k++){
					int cube = k*k*k;
					int res = cube - (arr[i]+arr[j]);
					if(res>0)
					count+=dp[n-1][res] -dp[j][res];
				}
			}
		}
		return count;
	}

	static void  computeDpArray(int arr[], int n)
	{
	    for (int i = 0; i < n; ++i) {
	        for (int j = 1; j <= 15000; ++j) {
	 
	            // if i == 0
	            // assign 1 to present state
	            if (i == 0)
	                dp[i][j] = (j == arr[i])?1:0;
	 
	            // else add +1 to current state with
	            // previous state
	            else{
	            	if(arr[i] == j){
	            		dp[i][j] = dp[i - 1][j] + 1;
	            	}else{
	            		dp[i][j] = dp[i - 1][j];
	            	}
	            }
	        }
	    }
	}
	
}
