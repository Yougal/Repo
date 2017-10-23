package com.yougal.random;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * 
 * A gene is represented as a string of length  (where  is divisible by ), composed of the letters , , , and . It is considered to be steady if each of the four letters occurs exactly  times. For example,  and  are both steady genes.

Bear Limak is a famous biotechnology scientist who specializes in modifying bear DNA to make it steady. Right now, he is examining a gene represented as a string . It is not necessarily steady. Fortunately, Limak can choose one (maybe empty) substring of  and replace it with any string of the same length.

Modifying a large substring of bear genes can be dangerous. Given a string , can you help Limak find the length of the smallest possible substring that he can replace to make  a steady gene?

Note: A substring of a string  is a subsequence made up of zero or more consecutive characters of .

Input Format

The first line contains an interger  divisible by , denoting the length of a string . 
The second line contains a string  of length . Each character is one of the four: , , , .

Constraints

 is divisible by 
Subtask

 in tests worth  points.
Output Format

On a new line, print the minimum length of the substring replaced to make  stable.

Sample Input

8  
GAAATAAA
Sample Output

5
Explanation

One optimal solution is to replace a substring  with , resulting in . The replaced substring has length , so we print  on a new line.
 * 
 * @author yougal.bisht
 *
 */
public class BearAndSteadyGame {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(Files.newInputStream(Paths.get("/Users/yougal.bisht/git/Repo/GFG/resource/BearAndSteadyGameInput1.txt"),StandardOpenOption.READ));
		int lengthOfString  = Integer.valueOf(sc.nextLine());
		String geneString = sc.nextLine();
		BearAndSteadyGame bearAndSteadyGame= new BearAndSteadyGame();
		int length = bearAndSteadyGame.findMinLengthStringToReplace(geneString,lengthOfString);
		System.out.println(length);
		sc.close();
	}

	private int findMinLengthStringToReplace(String geneString, int lengthOfString) {
		int eachCharCount = lengthOfString/4;
		int countA = 0;
		int countAAfterStart = 0;
		int countC = 0;
		int countCAfterStart = 0;
		int countG = 0;
		int countGAfterStart = 0;
		int countT = 0;
		int countTAfterStart = 0;
		int i = 0;
		int startIndex = -1;
		for(;i<lengthOfString;i++){
			switch(geneString.charAt(i)){
				case 'A' : countA ++;
						   if(startIndex>-1){
							   countAAfterStart++;
						   }
						   break;
				case 'C' : countC++;
						   if(startIndex>-1){
							   countCAfterStart++;
							}
							break;
				case 'G' : countG++;
						   if(startIndex>-1){
								   countGAfterStart++;
						    }
				   			break;
				case 'T' : countT++;
						    if(startIndex>-1){
								   countTAfterStart++;
						    }
	   						break;
			}
			if (startIndex==-1 && (countA>eachCharCount || countC>eachCharCount || 
					 countG>eachCharCount || countT>eachCharCount)){
				startIndex = i;
			}
				
		}
		
		int length=0;
		
		length+=calculateLength(eachCharCount, countA, countAAfterStart);
		length+=calculateLength(eachCharCount, countC, countCAfterStart);
		length+=calculateLength(eachCharCount, countG, countGAfterStart);
		length+=calculateLength(eachCharCount, countT, countTAfterStart);
		return length;
	}

	private int calculateLength(int eachCharCount, int count, int countAfterStart) {
		if(count<eachCharCount){
			return (eachCharCount-count) + countAfterStart;
		}
		return 0;
	}
	
}
