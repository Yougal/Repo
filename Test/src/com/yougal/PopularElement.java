package com.yougal;
/**
 * 
 *  Find popular item in sorted array of natural numbers. 
 *	An item is popular is if its repeated n/4 times or more. 
 *	For Ex: 
 *	Input: 123444445678 
 *	Popular item is 4. 
 *	Liner scan is O(n), but solution needs to be in O(logN) 
 *	complexity and O(1) space complexity.
 * 
 * 
 * @author yougal.bisht
 *
 */
public class PopularElement {

	
	
	public int findPopularElement(int a[]){
		int size = a.length;
		if(size<4){
			throw new IllegalArgumentException("inappropraite array size < 4");
		}
		/*
		 * if the element is popular element can be at location size/4, size/2, 3size/4, size
		 * 
		 * so pivot would be above location 
		 * 
		 */
		int pivot1 = (size/4)-1;
		int pivot2 = (size/2)-1;
		int pivot3 = ((3*size)/4)-1;
		int pivot4 = size-1;
		
		int loc = searchFirstOccurrenceOfPivot(a, a[pivot1],0,pivot1);
		if(a[loc]==a[loc+(size/4)]){
			return a[loc];
		}
		
		loc = searchFirstOccurrenceOfPivot(a, a[pivot2],0,pivot2);
		if(a[loc]==a[loc+(size/4)]){
			return a[loc];
		}
		
		
		loc = searchFirstOccurrenceOfPivot(a, a[pivot3],0,pivot3);
		if(a[loc]==a[loc+(size/4)]){
			return a[loc];
		}
		
		
		loc = searchFirstOccurrenceOfPivot(a, a[pivot4],0,pivot4);
		if(a[loc]==a[loc+(size/4)]){
			return a[loc];
		}
		
		return -1;
	}

	private int searchFirstOccurrenceOfPivot(int[] a, int pivotElement, int start,
											int end) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
