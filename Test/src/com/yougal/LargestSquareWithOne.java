package com.yougal;

public class LargestSquareWithOne {

	   public static void main(String[] args) {
           int matrix[][] = {  { 0, 1, 1, 0, 1, 1 },
   	                           { 1, 1, 0, 1, 1, 1 },
   	                           { 0, 1, 1, 1, 0, 0 },
   	                           { 1, 1, 1, 1, 0, 0 },
   	                           { 1, 1, 1, 1, 1, 0 },
   	                           { 0, 1, 1, 1, 0, 1 }
   	                         };
   	       System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
	   }

	private static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
		int table[][] = new int[matrix.length][];
		int maxValue=-99999;
		for (int i=0;i<matrix.length;i++) {
			if(table[i]==null){
				table[i]= new int[matrix[i].length];
			}
			for (int j=0;j<matrix[i].length;j++) {
				if(i==0 || j==0){
					table[i][j]=matrix[i][j];
				}else if(matrix[i][j]==0){
					table[i][j]=0;
				}else{
					table[i][j] =  Math.min(Math.min(table[i-1][j-1], table[i-1][j]),
							table[i][j-1]) +1;
				}
				maxValue = Math.max(table[i][j], maxValue);
			}
			
		}
		
		return maxValue;
	}
	
	
}
