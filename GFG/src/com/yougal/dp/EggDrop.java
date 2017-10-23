package com.yougal.dp;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EggDrop {

	public static void main(String[] args) {
		 int n = 2, k = 10;
		    System.out.printf ("\nMinimum number of trials in worst case with %d eggs and " +
		             "%d floors is %d \n", n, k, eggDrop(n, k));
	}
	
	static Map<Entry<Integer,Integer>, Integer> map= new HashMap<>();

	private static int eggDrop(int n, int totalNumberOfFloor) {
		if(n==1){
			return totalNumberOfFloor;
		}
		if(n==0){
			return 0;
		}
		if(totalNumberOfFloor==0 || totalNumberOfFloor==1){
			return totalNumberOfFloor;
		}
		
		int trialNumber = Integer.MAX_VALUE;
		for(int currentFloor=1;currentFloor<=totalNumberOfFloor;currentFloor++){
			//dropping the egg from current Floor two possibility are there
			// 1. egg will break, which means we need to search floor below currentFloor
			// 2. egg will not break, which means we need to search floor above currentFloor
			SimpleEntry<Integer,Integer> entry1 = new SimpleEntry<Integer, Integer>( n-1,  currentFloor-1);
			SimpleEntry<Integer,Integer> entry2 = new SimpleEntry<Integer, Integer>( n,  totalNumberOfFloor-currentFloor);
			int trailWhenEggBreaks = 0;
			if(map.containsKey(entry1)){
				trailWhenEggBreaks =map.get(entry1);
			}else{
				 trailWhenEggBreaks  = eggDrop( n-1,  currentFloor-1);
			}
			
			int trailWhenEggNotBreaks = 0;
			if(map.containsKey(entry2)){
				trailWhenEggNotBreaks =map.get(entry2);
			}else{
				trailWhenEggNotBreaks  = eggDrop( n,  totalNumberOfFloor-currentFloor);
			}
			int worstCase = Math.max(trailWhenEggBreaks, trailWhenEggNotBreaks);
			trialNumber = Math.min(trialNumber, worstCase);
		}
		map.put(new SimpleEntry<Integer, Integer>( n,  totalNumberOfFloor), trialNumber+1);
		return trialNumber+1;
	}
	
	
}
