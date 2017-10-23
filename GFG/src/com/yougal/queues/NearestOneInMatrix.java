package com.yougal.queues;


/**
 * 
 * Distance of nearest cell having 1 in a binary matrix.
 * Given a binary matrix of N x M, containing at least a value 1. 
 * The task is to find the distance of nearest 1 in the matrix for each cell. 
 * The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number 
 * and column number of the current cell and i2, j2 are the row number and column number 
 * of the nearest cell having value 1.
 * 
 * Examples:
 * 
 * Input : N = 3, M = 4
 * 		mat[][] = { 
 * 					0, 0, 0, 1,
 * 					0, 0, 1, 1,
 * 					0, 1, 1, 0 
 * 				  }
 * 
 * Output : 3 2 1 0
 * 			2 1 0 0
 * 			1 0 0 1
 * 
 * For cell at (0, 0), nearest 1 is at (0, 3), so distance = (0 - 0) + (3 - 0) = 3.
 * Similarly all the distance can be calculated.
 * 
 * <a href="http://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix">Problem Link</a>
 * 
 * @author yougal.bisht
 *
 */
public class NearestOneInMatrix {

	public static void main(String[] args) {
		int mat[][] =new int[][] { 
				{0, 0, 0, 1},
				{0, 0, 1, 1},
				{0, 1, 1, 0 }
			  };
			  
		int output[][]=new int[][] { 
			{-1, -1, -1, -1},
			{-1, -1, -1, -1},
			{-1, -1, -1, -1 }
		  };  
		 int row=3;
		 int col=4;
		 findNearestOnes(mat,row,col,0,0,output);
		  
		  
		  
	}

	private static void findNearestOnes(int[][] mat, int row, int col, int i, int j, int[][] output) {
		if(mat[i][j]==1){
			output[i][j]=0;
		}
		if(output[i][j]<0){
		}
	}

	private static int findMinDistanceToOne(int[][] mat, int row, int col, int i, int j, int[][] output) {
		if(mat[i][j]==1){
			return 0;
		}
		int min =Integer.MAX_VALUE;
		int startRow = i-1<0?i:i-1;
		int endRow= i+1>row?i:i+1;
		int startCol = j-1<0?i:j-1;
		int endCol= j+1>col?i:j+1;
		for(int p=startRow;p<endRow;p++){
			for(int q=startCol;p<endCol;q++){
				if(i==p&& j==q){
					continue;
				}
				if(output[p][q]>0){
					min = Math.min(min, output[p][q]);
				}else{
					
				}
			}
		}
		
		return 0;
	}
	
	
	
}
