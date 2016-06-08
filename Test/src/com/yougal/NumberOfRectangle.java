package com.yougal;

public class NumberOfRectangle {

	public static void main(String[] args) {
		NumberOfRectangle numberOfRectangle = new NumberOfRectangle();
		System.out.println(numberOfRectangle.countRectangle(4,6));
	}

	public int  countRectangle(int maxRow, int maxCol){
		int count =0 ;
		for(int p=1;p<=maxRow;p++){
			for(int q=1;q<=maxCol;q++){	
				for(int i=0;i<maxRow;i++){
					for(int j=0;j<maxCol;j++){
						if(i+p<=maxRow && j+q<=maxCol){
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
}
