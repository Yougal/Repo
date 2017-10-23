package com.yougal.array;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/print-kth-element-spiral-form-matrix/
 * 
 * @author yougal.bisht
 *
 */
public class KthElementInSpiralMatrix {
	
	public static void main(String[] args) {
		int a[][] = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};
		
		int k = 6;
	    System.out.println(findK(a,0, 4,0, 4,k));
	}

	private static int findK(int[][] a,int startRow ,int endRow, int startCol, int endCol, int k) {
		if(endRow-startRow<1 || endCol-startCol<1){
			return -1;
		}
		int cols= endCol-startCol;
		int row= endRow-startRow;
		if(k<=cols){
			//element in first Row
			return a[startRow][startCol+k-1];
			
		}else if(k<cols+row-1){
			//element in last col
			return a[startRow+k-cols][startCol+cols-1];
		}else if(k<cols+row-1+cols-1){
			//element in last row
			return a[startRow+row-1][startCol+(cols-1)-(k-(cols+row-1))];
		}else if (k <= (cols+row-1+cols-1+row-2)){
			//element in first col
	        return a[startRow+(row-1)-(k-(cols+row-1+cols-1))][startCol];
		}else{
			return findK(a,startRow+1, endRow-1, startCol+1 ,endCol-1, k-(cols+row-1+cols-1+row-2));
		}
	}
	
}
