package com.yougal;
/**
 * Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s. 
 * E.x array is {1,1,0,0,1,1,1,0,1,1} k = 1 (which means we can flip ‘k’ one 0 to 1) 
 * Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)
 * 
 * @author yougal.bisht
 *
 */
public class FlipFirstKZeros {

	public static void main(String[] args) {
		int arr[] = {1,1,0,0,1,1,1,0,1,1};
		int k=1;
		
		int maxSumInCurrentCycle = 0;
		int maxSum=0;
		int flippedZeros=k;
		for (int i=0;i<arr.length;i++) {
			if(arr[i]==1){
				maxSumInCurrentCycle++;
			}else if(arr[i]==0){
				if(flippedZeros>0){
					maxSumInCurrentCycle++;
					flippedZeros--;
				}else{
					 flippedZeros = k;
					 maxSum = Math.max(maxSum, maxSumInCurrentCycle);
					 maxSumInCurrentCycle=0;
				}
			}
			
		}
		maxSum = Math.max(maxSum, maxSumInCurrentCycle);
		System.out.println("Maximum Sum: " + maxSum);
		
	}
	
	
}
