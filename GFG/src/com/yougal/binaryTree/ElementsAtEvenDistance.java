package com.yougal.binaryTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/even-distanced-tree-vertices/0
 * 
 * You have a tree consisting of N vertices. Print the number of Pairs of nodes that are at an even distance.
 * 
 * Input:
 * 		The First line contains an integer T, the number of test cases.
 * 		The first line of each test case contains an integer N , the total number of vertices. 
 * 		The (N-1) subsequent lines each contain two space-separated vertices (u and v) connecting nodes in the tree.
 * Output:
 * 		Print the total number of pairs having even distance between them.
 * Constraints:
 * 		1<=T<=10
 * 		1<= N <=10000
 * 		1<= u, v <=N
 * Example:
 * 		Input:
 * 				1
 * 				5
 * 				1 3
 * 				1 2
 * 				2 4
 * 				3 5
 * 		Output:
 * 				4
 * Explanation:
 * 
 * 		There are  pairs with even distance between them:
 * 		(2,3) distance=2
 * 		(4,5) distance=4
 * 		(4,1) distance=2
 * 		(1,5) distance=2

 * @author yougal.bisht
 *
 */
public class ElementsAtEvenDistance {

	public static void main(String[] args) throws FileNotFoundException {
		Path path = Paths.get("/Users/yougal.bisht/git/Repo/GFG/resource/elementInput.txt");
		FileInputStream inputStrem = new FileInputStream(path.toFile());
		Scanner sc = new Scanner(inputStrem);
		int numberTestCase  = Integer.valueOf(sc.nextLine());
		while (numberTestCase>0) {
			int count = doForEachInput(sc);
			System.out.println(count);
			numberTestCase--;
		}
		sc.close();
	}

	private static int doForEachInput(Scanner sc) {
		int numberOfVertices =Integer.valueOf(sc.nextLine());
		int parent[] = new int [numberOfVertices+1];
		Arrays.fill(parent, -1);
		int count=0;
		String s[] =sc.nextLine().split(" ");
		for(int input = 0;input<s.length;input=input+2) {
			int u = Integer.valueOf(s[input]);
			int v = Integer.valueOf(s[input+1]);
			parent[v]=u;
		}
		int level[] = assignLevel(parent);
		for(int i=1;i<numberOfVertices+1;i++) {
			for(int j=i+1;j<numberOfVertices+1;j++) {
				int distance = findDistance(parent, level, i, j);
				if(distance%2==0) {
					count++;
				}
			}
		}
		return count;
	}

	private static int[] assignLevel(int[] parent) {
		int[] levelArray= new int[parent.length];
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		while(!stk.isEmpty()){
			int parentIndex=stk.pop();
			for(int i=1;i<parent.length;i++) {
				if(parent[i]==parentIndex) {
					stk.push(i);
					levelArray[i] = parentIndex<0? 0: levelArray[parentIndex]+1;
				}
			}
		}
		return levelArray;
	}

	private static int findDistance(int[] parent, int[] level, int from, int to) {
		int lcaIndex = findLCA(parent,from,to);
		return (level[lcaIndex] - level[from] )+ (level[lcaIndex]-level[to]);
	}

	private static int findLCA(int[] parent, int from, int to) {
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();
		stk1.push(from);
		stk2.push(to);
		while(stk1.peek()!=-1 && stk2.peek()!=-1) {
			stk1.push(parent[stk1.peek()]);
			stk2.push(parent[stk2.peek()]);
		}
		if(stk1.peek()==-1) {
			stk1.pop();
		}
		if(stk2.peek()==-1) {
			stk2.pop();
		}
		int lastCommon=-1;
		while(!stk1.isEmpty() && !stk2.empty() && stk1.peek() != stk2.peek()) {
			lastCommon = stk1.pop();
			stk2.pop();
		}
		while(!stk1.isEmpty() && !stk2.empty() && stk1.peek() == stk2.peek()) {
			lastCommon = stk1.pop();
			stk2.pop();
		}
		return lastCommon;
	}

}
