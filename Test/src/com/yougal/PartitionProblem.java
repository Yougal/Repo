package com.yougal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PartitionProblem {

	public static void main(String[] args) 
	    {
		        PartitionProblem solution = new PartitionProblem();
		        
		        int[] set = {45,15,5,15,20};
		        
		        System.out.println(solution.partitionExists(set));
		}

	private boolean partitionExists(int[] set) {
		int sum = Arrays.stream(set).sum();
		if(sum%2!=0){
			return false;
		}
		List<Integer> result = new ArrayList<Integer>();
		canAddNumber(set,sum/2,0,result);
		System.out.println(result);
		return true;
	}
	
	public boolean canAddNumber(int []arry, int sum,int index, List<Integer> set){
		if(sum<0 || index>=arry.length){
			return false;
		}
		if(sum==0){
			return true;
		}
		
		boolean result = canAddNumber(arry, sum-arry[index], index+1,set);
		if(result){
			set.add(arry[index]);
		}else{
			result = canAddNumber(arry, sum, index+1,set);
		}
		return result;
	}
	
	
	
}
