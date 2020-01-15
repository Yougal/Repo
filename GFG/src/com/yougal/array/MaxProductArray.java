 package com.yougal.array;

public class MaxProductArray {
	
	 public static void main (String[] args) {
		 
	        int arr[] = {1, -2, 7,8,-1};
	        System.out.println("Maximum Sub array product is "+
	                            maxSubarrayProduct(arr));
	 }

	private static int maxSubarrayProduct(int[] arr) {
		int maxProduct=Integer.MIN_VALUE;
		int productSoFar1=1;
		int productSoFar2=1;
		int flip =1;
		int negativeNumber=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0 && flip==1) {
				productSoFar1*=arr[i];
				maxProduct=Math.max(maxProduct, productSoFar1);
			}else if(arr[i]>0 && flip==2) {
				productSoFar2*=arr[i];
				maxProduct=Math.max(maxProduct, productSoFar2);
			}else if(arr[i]<0 && flip==1) {
				negativeNumber=arr[i];
				flip=2;
			}else if(arr[i]<0 && flip==2) {
				productSoFar1 = productSoFar1*productSoFar2 * negativeNumber * arr[i];
				flip=1;
				maxProduct=Math.max(maxProduct, productSoFar1);
			}else {
				productSoFar1=1;
				productSoFar2=1;
				flip=1;
			}
		}
		return maxProduct;
	}

}
