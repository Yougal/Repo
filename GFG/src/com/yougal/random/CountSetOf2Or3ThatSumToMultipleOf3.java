package com.yougal.random;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
 * 
 * @author yougal.bisht
 *
 */
public class CountSetOf2Or3ThatSumToMultipleOf3 {

	public static void main(String[] args) {
		int arr[] = {3, 6, 7, 2, 9};
		int remainderArray[] = new int [3]; 
		for (int i : arr) {
			remainderArray[i%3]=remainderArray[i%3]+1;
		}
		
		//for groups Of 2
		// Number of elements = group 2 elements with remainder 0 
		//						group 2 elements with remainder 1 and 2
		
		int sum =0;
		sum = (remainderArray[0]*(remainderArray[0]-1))/2;
		sum+= remainderArray[1]*remainderArray[2];
		
		//for groups Of 3
		// Number of elements = group 3 elements with remainder 0 
		//						group 3 elements with remainder 1 
		//						group 3 elements with remainder 2 
		//						group 3 elements with remainder 0,1,2
		
		sum+= (remainderArray[0]*(remainderArray[0]-1)*(remainderArray[0]-2))/6;
		sum+= (remainderArray[1]*(remainderArray[1]-1)*(remainderArray[1]-2))/6;
		sum+= (remainderArray[2]*(remainderArray[2]-1)*(remainderArray[2]-2))/6;
		sum+= remainderArray[0]*(remainderArray[1])*(remainderArray[2]);
		
		System.out.println(sum);
	}
	
	
}
