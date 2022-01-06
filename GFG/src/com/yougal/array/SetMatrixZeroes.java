package com.yougal.array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
 * 
 * @author yougal.bisht
 *
 */
public class SetMatrixZeroes {


	public void setZeroes(int[][] matrix) {
		OptionalInt anyFirstRowItemZero = Arrays.stream(matrix[0]).filter(f->f==0).findFirst();
		boolean firstCol=false;
		for(int i=0;i<matrix.length;i++) {
	        if(matrix[i][0] == 0) {
	            firstCol = true;
	        	break;
	        }
		}
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		   
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0) {
					matrix[i][j]=0;
				}
			}
		}
		if(anyFirstRowItemZero.isPresent()) {
			for(int j=0;j<matrix[0].length;j++) {
				matrix[0][j]=0;
			}
		}
		if(firstCol) {
			for(int i=0;i<matrix.length;i++) {
		        matrix[i][0]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{0,1,2,0},{3,0,5,2},{1,3,1,5}};
		SetMatrixZeroes SetMatrixZeroes =  new  SetMatrixZeroes();
		System.out.println("---------------Input-----------------");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		SetMatrixZeroes.setZeroes(matrix);
		System.out.println("---------------output-----------------");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		
	}
}
