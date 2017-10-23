package com.yougal.bt;

public class RatInAMaze {

	public static void main(String[] args) {
		int maze[][]  =  {
				{1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		    };
		 
		    solveMaze(maze);
	}

	private static void solveMaze(int[][] maze) {
		int sol[][] = { 
				{0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0}
		    };
		 
		    if(solveMazeUtil(maze, 0, 0, sol)){
		    	printSolution(sol);   
		    }else{
		    	 System.out.printf("Solution doesn't exist");
		    }
	}

	private static boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
		if(i==maze.length-1 && j==maze[0].length-1){
			sol[i][j]=1;
			return true;
		}else{
			if(isSafe(maze,i,j)){
				sol[i][j] = 1;
				
				if(solveMazeUtil(maze, i+1, j, sol)){
					return true;
				}
				
				if(solveMazeUtil(maze, i, j+1, sol)){
					return true;
				}
				
				sol[i][j]=0;
				return false;
			}else{
				return false;
			}
		}
		
	}

	private static boolean isSafe(int[][] maze, int i, int j) {
		if(i>=maze.length || j>=maze[0].length){
			return false;
		}
		
		if(maze[i][j]==1){
			return true;
		}else{
			return false;
		}
	}
	
	
	/* A utility function to print solution matrix sol[N][N] */
	static void printSolution(int sol[][])
	{
	    for (int i = 0; i <sol.length; i++)
	    {
	        for (int j = 0; j < sol[i].length; j++)
	        	System.out.printf(" %d ", sol[i][j]);
	        System.out.printf("\n");
	    }
	}
	
}
