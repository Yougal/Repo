package com.yougal.array;

import java.util.Arrays;
/**
 * 
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * 
 * @author yougal.bisht
 *
 */

public class RotateMatrix {

	
	public static void main(String[] args) {
		int size =5;
		int counter=1;
		int m[][] =new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = counter++;
			}
		}
		System.out.println("---------------- Original Matrix ----------------");
		printMatrix(m);
		rotateMatrix(m, size);
		System.out.println("---------------- Rotated Matrix ----------------");
		printMatrix(m);
		
	}
	

	private static void rotateMatrix(int[][] m, int size) {
		
		for(int x=0;x<size/2;x++) {
			
			for(int y=x;y<size-x-1;y++) {
				
				int temp = m[x][y];
				
				m[x][y]=m[y][size-1-x];
				
				m[y][size-1-x]=m[size-1-x][size-1-y];
				
				m[size-1-x][size-1-y]=m[size-1-y][x];
				
				m[size-1-y][x]=temp;
			}
			
		}
		
	}

	private static void printMatrix(int[][] m) {
		for (int[] is : m) {
			System.out.println(Arrays.toString(is));
		}
	}
	
}
