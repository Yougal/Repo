package com.yougal.dp;

import java.util.Arrays;

public class Maze {
	
	public static void main(String[] args) {
		int maze[][] = {{0, 0, 1},  
		            {1, 1, 1},  
		            {1, 1, 0}};
		int result[][] = new int [maze.length][maze.length];
		for (int [] row: result)
		    Arrays.fill(row, Integer.MAX_VALUE);
		doesPathExists(maze, maze.length-1,maze.length-1, 1,result);
		if(result[maze.length-1][maze.length-1]!=Integer.MAX_VALUE) {
			System.out.println("Path Found");
		}else {
			System.out.println("Path Not Found");
		}
		
	}
	

	private static int  doesPathExists(int[][] maze, int row, int col, int k, int result[][]) {
		if(row<0 || col<0 || k<0) {
			return Integer.MAX_VALUE;
		}else {
			if(row==0 && col==0) {
				return 1;
			}else if(result[row][col]!=Integer.MAX_VALUE) {
					return result[row][col];
			}else {
				if(maze[row][col]==0) {
					result[row][col]= Math.min(doesPathExists(maze, row-1, col, k, result), doesPathExists(maze, row, col-1, k, result));
				}else {
					result[row][col]= Math.min(doesPathExists(maze, row-1, col, k-1, result), doesPathExists(maze, row, col-1, k-1, result));
				}
				return result[row][col];
			}
		}
	}

}
