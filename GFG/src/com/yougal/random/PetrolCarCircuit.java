package com.yougal.random;

public class PetrolCarCircuit {
	
	public static void main(String[] args) {
		PetrolCarCircuit petrolCarCircuit = new PetrolCarCircuit();
		int indexToStart = petrolCarCircuit.canCompleteCircuit(new int [] {3,3,4},new int[] {3,4,4});
		indexToStart = petrolCarCircuit.canCompleteCircuit(new int [] {1,2,3,4,5},new int[] {3,4,5,1,2});
		System.out.println(indexToStart);
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int startIndex=0;
        int start=0;
        int end=gas.length;
        do {
        	int gasLeft=gas[startIndex];
        	start=startIndex;
        	while(gasLeft-cost[start]>=0) {
        		gasLeft-=cost[start];
        		start=(start+1)%gas.length;
        		if(start==startIndex) {
        			return start;
        		}else {
        			gasLeft+=gas[start];
        		}
        	}
        	startIndex=startIndex+1;
        }while(startIndex!=end);
		return -1;
    }

}
