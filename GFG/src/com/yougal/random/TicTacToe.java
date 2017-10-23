package com.yougal.random;

public class TicTacToe {
	
	public static void main(String[] args) {
		 char board[] = {
				 		 'X', 'O', 'O',
                 		 'O', 'O', 'X',
                 		 'X', 'X', 'X'
                 		 };
		 	if(isValid(board)){
				System.out.println("Given board is valid");
		 	}else{
		 		System.out.println("Given board is not valid");
		 	}
	}
	
	// This matrix is used to find indexes to check all
	// possible wining triplets in board[0..8]
	static int win[][] = {	{0, 1, 2}, // Check first row.
			                {3, 4, 5}, // Check second Row
			                {6, 7, 8}, // Check third Row
			                {0, 3, 6}, // Check first column
			                {1, 4, 7}, // Check second Column
			                {2, 5, 8}, // Check third Column
			                {0, 4, 8}, // Check first Diagonal
			                {2, 4, 6}
			              }; // Check second Diagonal

	private static boolean isValid(char[] board) {
		 // Count number of 'X' and 'O' in the given board
	    int xCount=0, oCount=0;
	    for (int i=0; i<9; i++){
	       if (board[i]=='X') xCount++;
	       if (board[i]=='O') oCount++;
	    }
	    boolean xWin = isCWin(board, 'X');
	    boolean oWin = isCWin(board, 'O');
		if(xWin && oWin){
	    	return false;
	    }
		
		if(xWin && xCount!=oCount+1){
			return false;
		}
		
		if(oWin && xCount!=oCount){
			return false;
		}
		
		if(xCount!=oCount+1){
			return false;
		}
		
		
		return true;
	}

	private static boolean isCWin(char[] board, char c) {
		for(int i=0;i<8;i++){
			if(board[win[i][0]]==c &&
					board[win[i][1]]==c &&
					board[win[i][2]]==c){
				 return true;
			}
		}
		return false;
	}

}
