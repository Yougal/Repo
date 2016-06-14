package com.yougal;

import java.util.Arrays;

public class PartitionProblem {

	public static void main(String[] args) 
	    {
		        PartitionProblem solution = new PartitionProblem();
		        
		       // int[] set = {15,5,15,20,45};
		        int[] set = {2,3,7,8,10};
		        Arrays.sort(set);
		        System.out.println(solution.partitionExists(set));
		}

	private boolean partitionExists(int[] set) {
		int sum = Arrays.stream(set).sum();
		if(sum%2!=0){
			return false;
		}
		sum = sum/2;
		boolean solution[][] = new boolean[set.length][sum+1];
		for(int j =0 ;j<set.length;j++){
			solution[j][0]=true;
		}
		for (int i = 0; i < set.length; i++) {
			for (int j = 1; j<=sum; j++) {
				if(j<set[i]){
					if(i-1>=0){
						solution[i][j] = solution[i-1][j];
					}else{
						solution[i][j] = false;
					}
				}else if(set[i]==j){
					solution[i][j]=true;
				}else{
					if(i-1>=0){
						solution[i][j] = solution[i-1][j-set[i]];	
					}else{
						solution[i][j] = false;
					}
					
				}
			}
		}
		printElements(solution,set,sum);
		return solution[set.length-1][sum];
	}

	private void printElements(boolean[][] solution, int[] set, int sum) {
		StringBuilder s = new StringBuilder("{");
		int i=set.length-1;
		if(solution[i][sum]){
			i--;
			while(i>=0 && sum>0){
				if(solution[i][sum]){
					s.append(set[i]+", ");
					sum = sum-set[i];
					i--;
					continue;
				}if(solution[i][sum-set[i+1]] ){
					s.append(set[i]+", ");
					sum = sum-set[i+1];
					i--;
					continue;
				}else{
					break;
				}
			}
		}
		s.append("}");
		System.out.println(s.toString());
	}
	
	
	
	
}
