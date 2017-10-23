package com.yougal.dp;

public class OptimalStrategyGame {
	
	
	public static void main(String[] args) {
		int arr1[] = {8, 15, 3, 7};
	    int n = arr1.length;
	    System.out.printf("%d\n", optimalStrategyOfGame(arr1, 0, n-1));
	 
	    int arr2[] = {2, 2, 2, 2};
	    n =arr2.length;
	    System.out.printf("%d\n", optimalStrategyOfGame(arr2,0, n-1));
	 
	    int arr3[] = {20, 30, 2, 2, 2, 10};
	    n =arr3.length;
	    System.out.printf("%d\n", optimalStrategyOfGame(arr3,0, n-1));
		 
	}

	private static int optimalStrategyOfGame(int[] arr, int i, int j) {
		if(i==j){
			return arr[i];
		}else if(j==i+1){
			return Math.max(arr[i], arr[j]);
		}else{
			//if user chooses i then
			
			int userChoosesI = arr[i] + Math.min(optimalStrategyOfGame(arr, i+2, j), 
												 optimalStrategyOfGame(arr, i+1, j-1));
			
			
			//if user chooses j then
			int userChoosesJ = arr[j] + Math.min(optimalStrategyOfGame(arr, i, j-2), 
					 					optimalStrategyOfGame(arr, i+1, j-1));
			return Math.max(userChoosesI, userChoosesJ);
		}
	}

}
