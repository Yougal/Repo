package com.yougal.array;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * 
 * @author yougal.bisht
 *
 */
public class EquilibriumIndex {

	public static void main(String[] args) {
		 int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		 int index =  equilibrium(arr, arr.length);
		 System.out.println(index);
		  
	}

	private static int equilibrium(int[] arr, int length) {
		int sumLeft=0;
		int sumRight=0;
		for (int i = 0; i < length; i++) {
			sumRight+=arr[i];
		}
		for (int i = 0; i < length; i++) {
			sumRight-=arr[i];
			if(sumLeft==sumRight){
				return i;
			}
			sumLeft+=arr[i];
		}
		
		return -1;
	}
	
}
