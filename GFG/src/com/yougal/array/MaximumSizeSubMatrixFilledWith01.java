package com.yougal.array;
/**
 * 
 * 
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * 
 * @author yougal.bisht
 *
 */
public class MaximumSizeSubMatrixFilledWith01 {

	
	public static void main(String[] args) {
		  int matrix[][] ={{0, 1, 1, 0, 1}, 
		                   {1, 1, 0, 1, 0}, 
		                   {0, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 1},
		                   {0, 0, 0, 0, 0}};
		                
		  printMaxSubSquare(matrix);
	}

	private static void printMaxSubSquare(int[][] matrix) {
		int aux[][] = new int[matrix.length][];
		
		  for(int i = 0; i < matrix.length; i++) {
			 aux[i] = new int[matrix[i].length];
		     aux[i][0] = matrix[i][0];
		  }
		  
		  for(int j = 0; j < matrix[0].length; j++) {
		     aux[0][j] = matrix[0][j];
		  }
		  for(int i = 1; i < matrix.length; i++) {
			  for(int j = 1; j < matrix[i].length; j++) {
				 if(matrix[i][j]==1) {
					 aux[i][j] = Math.min(aux[i-1][j-1], Math.min(aux[i][j-1], aux[i-1][j]))+1;
				 }else {
					 aux[i][j]=0;
				 }
			  }
		  }
		  int maxValue=0;
		  int maxI=0;
		  int maxJ=0;
		  for(int i = 0; i < matrix.length; i++) {
			  for(int j = 0; j < matrix[i].length; j++) {
				  if(maxValue<=aux[i][j]) {
					  maxValue=aux[i][j];
					  maxI=i;
					  maxJ=j;
				  }
			  }
		  }
		  
		  for(int i=maxI-maxValue+1;i<=maxI;i++) {
			  for(int j=maxJ-maxValue+1;j<=maxJ;j++) { 
				  System.out.print(matrix[i][j] + " ");
			  }
			  System.out.println();
		  }
	}
	
}
