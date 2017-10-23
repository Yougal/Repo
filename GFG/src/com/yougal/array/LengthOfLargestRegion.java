package com.yougal.array;
/**
 * 
 *  Find length of the largest region in Boolean Matrix
	Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally .If one or more filled cells are also connected, they form a region. find the length of the largest region.
	
	Examples:
	
	Input : M[][5] = { 0 0 1 1 0
	                   1 0 1 1 0
	                   0 1 0 0 0
	                   0 0 0 0 1 }
	Output : 6 
	Ex: in the following example, there are 2 regions one with length 1 and the other as 6.
	    so largest region : 6
 * 
 * 
 * 
 *  
 *  http://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
 * 
 * 
 *  Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands

	Input : mat[][] = {{1, 1, 0, 0, 0},
	                   {0, 1, 0, 0, 1},
	                   {1, 0, 0, 1, 1},
	                   {0, 0, 0, 0, 0},
	                   {1, 0, 1, 0, 1} 
	Output : 5
	
 *	http://www.geeksforgeeks.org/find-number-of-islands/
 * 
 * 
 * @author yougal.bisht
 *
 */
public class LengthOfLargestRegion {

	public static void main(String[] args) {
		
		
		int M[][] = {   {0, 0, 1, 1, 0,1,1},
		                {1, 0, 1, 1, 0,1,1},
		                {0, 1, 0, 0, 0,1,1},
		                {0, 0, 0, 0, 1,1,1}
		            };
		
		
		int lengthOfLargestRegion = findLengthOfLargestRegion(M);
		
		System.out.println("Length: " + lengthOfLargestRegion);
		
	}

	private static int findLengthOfLargestRegion(int[][] m) {
		int maxLength = 0;
		 for (int i = 0; i < m.length; ++i){
		        for (int j = 0; j < m[i].length; ++j){
		        	if(m[i][j]==1){
		        		int length = findLength(m, i, j);
		        	    maxLength=Math.max(maxLength, length);
		        	}
		        }
		 }
		 return maxLength;
	}
	static int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

	private static int findLength(int[][] m, int i, int j) {
		m[i][j]=-1;
		int length=1;
		for(int k=0;k<rowNbr.length;k++){
			if(isSafe(m,i+rowNbr[k],j+colNbr[k])){
				length= length +findLength(m,i+rowNbr[k],j+colNbr[k]);
			}
		}
		return length;
	}

	private static boolean isSafe(int[][] m, int i, int j) {
		return (i >= 0) && (i < m.length) &&
		           (j >= 0) && (j < m[i].length) && m[i][j]==1;
	}
	
}
