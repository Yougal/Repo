package com.yougal.array;

public class MaxProductArray {
	
	 public static void main (String[] args) {
		 
	        int arr[] = {1, -2, -3, 0, 7, -8, -2};
	        System.out.println("Maximum Sub array product is "+
	                            maxSubarrayProduct(arr));
	 }

	private static int maxSubarrayProduct(int[] arr) {
		int maxProduct=arr[0];
		int productSoFar=arr[0];
		for (int i = 1; i < arr.length; i++) {
			
			productSoFar*=arr[i];
			if(productSoFar==0){
				if(i+1<arr.length){
					productSoFar=arr[i+1];
					i++;
				}
			}
			
			if(productSoFar>maxProduct){
				maxProduct=productSoFar;
			}
			
		}
		return maxProduct;
	}

}
