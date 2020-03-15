package com.yougal.array;

public class MinPathSumInMatrix {
	
	
	public int minPathSum(int[][] A) {
        int result[][]= new int[A.length][A[0].length];
        for (int i=0;i<result.length;i++) {
        	result[i]= new int[A[0].length];
        }
        result[0][0]=A[0][0];
        for(int i=1;i<A.length;i++) {
        	result[i][0]=result[i-1][0]+A[i][0];
        }
        for(int i=1;i<A[0].length;i++) {
        	result[0][i]=result[0][i-1]+A[0][i];
        }
        for(int i=1;i<A.length;i++) {
        	 for(int j=1;j<A[0].length;j++) {
             	result[i][j]+=A[i][j]+Math.min(result[i-1][j],result[i][j-1]);
             }
        }
        
        
		return result[A.length-1][A[0].length-1];  
    }
    
    public static void main(String[] args) {
    	MinPathSumInMatrix minPathSumInMatrix = new MinPathSumInMatrix();
    	int minPathSum = minPathSumInMatrix.minPathSum(new int[][]{
    	                                          		  {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
    	                                        		  {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
    	                                        		  {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
    	                                        		  {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
    	                                        		  {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
    	                                        		  {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
    	                                        		  {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
    	                                        		  {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
    	                                        		});
    	System.out.println(minPathSum);
	}
}

