package com.yougal.random;

public class TrappedWater {
	
	public static void main(String[] args) {
		int arr[]= {4,0,0,2,0,3};
		int value =  findTotalTrappedWater(arr);
		System.out.println(value);
	}

	private static int findTotalTrappedWater(int[] arr) {
		// initialize output 
	    int result = 0; 
	  
	    // maximum element on left and right 
	    int left_max = 0, right_max = 0; 
	  
	    // indices to traverse the array 
	    int lo = 0, hi = arr.length-1; 
	  
	    while (lo <= hi) { 
	        if (arr[lo] < arr[hi]) { 
	            if (arr[lo] > left_max) 
	                // update max in left 
	                left_max = arr[lo]; 
	            else
	                // water on curr element = max - curr 
	                result += left_max - arr[lo]; 
	            lo++; 
	        } 
	        else { 
	            if (arr[hi] > right_max) 
	                // update right maximum 
	                right_max = arr[hi]; 
	            else
	                result += right_max - arr[hi]; 
	            hi--; 
	        } 
	    } 
	  
	    return result; 
	}

}
