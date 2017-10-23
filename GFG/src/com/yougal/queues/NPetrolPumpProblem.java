package com.yougal.queues;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the first circular tour that visits all petrol pumps.
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
 * 
 * 		1. The amount of petrol that every petrol pump has.
 * 		2. Distance from that petrol pump to the next petrol pump.
 * 
 * Calculate the first point from where a truck will be able to complete the circle
 * (The truck will stop at each petrol pump and it has infinite capacity). 
 * Expected time complexity is O(n). Assume for 1 litre petrol, the truck can go 1 unit of distance.
 * 
 * For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump 
 * value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make
 * a circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).
 * 
 * 
 * @author yougal.bisht
 *
 */
public class NPetrolPumpProblem {

	
	public static void main(String[] args) {
		List<PetrolPump> listPetrolPump = prepareData(
				new int[]{4, 6}, 
				new int[]{6, 5}, 
				new int[]{7, 3},
				new int[]{4, 5}
				);
		int start =0;
		int petrolLeft=0;
		int n=0;
		int i=0;
		while(n<listPetrolPump.size()){
			
			if(petrolLeft<0){
				n--;
				petrolLeft = petrolLeft- (listPetrolPump.get(start).petrol - listPetrolPump.get(start).distanceToNextPump);
				start++;
			}else{
				petrolLeft = petrolLeft+ (listPetrolPump.get(i).petrol - listPetrolPump.get(i).distanceToNextPump);
				n++;
				i=(i+1)%listPetrolPump.size();
			}
		}
		
		
		if(petrolLeft<0){
			start=-1;
		}
		
		System.out.println("You can traverse starting index: " + start);
		
	}
	
	
	
	private  static List<PetrolPump> prepareData(int[]...a){
		List<PetrolPump> ppl = new ArrayList<PetrolPump>(); 
		for (int[] is : a) {
			PetrolPump pp = new PetrolPump(is[0],is[1]);
			ppl.add(pp);
		}
		return ppl;
	}
	
	

	public static class PetrolPump{
		
		int distanceToNextPump;
		int petrol;
		
		public PetrolPump(int petrol, int distanceToNextPump) {
			super();
			this.distanceToNextPump = distanceToNextPump;
			this.petrol = petrol;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "PetrolPump [distanceToNextPump=" + distanceToNextPump + ", petrol=" + petrol + "]";
		}
		
		
	}
	
}
