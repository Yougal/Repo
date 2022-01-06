package com.yougal.array;
/**
 * https://www.geeksforgeeks.org/find-all-ranges-of-consecutive-numbers-from-array/
 * @author yougal.bisht
 *
 */
public class AllRangesOfConsecutiveNumbers {
	
	public static void main(String[] args) {
		printAllRanges(new int[]{1, 2, 3, 6, 7});
		System.out.println("--------------------------------");
		printAllRanges(new int[]{-1, 0, 1, 2, 5, 6, 8} );
	}
	
	static void printAllRanges(int a[]){
		int l = a.length;
		int firstNum=a[0];
		int lasNum=a[0];
		for (int i=1;i<l;i++) {
			if(lasNum+1==a[i]) {
				lasNum= a[i];
			}else {
				System.out.println(firstNum + "->" + lasNum);
				firstNum=a[i];
				lasNum=a[i];
			}
		}
		System.out.println(firstNum + "->" + lasNum);
	}

}
