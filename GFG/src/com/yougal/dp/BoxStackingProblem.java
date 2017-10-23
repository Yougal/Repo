package com.yougal.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class BoxStackingProblem {

	
	private static class Box implements Comparable<Box>{
		 int l,b,h;

		public Box(int l, int b, int h) {
			super();
			this.l = l;
			this.b = b;
			this.h = h;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Box [l=" + l + ", b=" + b + ", h=" + h + "]\n";
		}

		@Override
		public int compareTo(Box o2) {
			return (o2.l*o2.b) - (this.l*this.b);
		}
		
		
	}
	
	public static void main(String[] args) {
		Box arr[] = { new Box(4,6,7), 
					  new Box(1, 2, 3), 
				      new Box(4, 5, 6), 
				      new Box(10,12,32) 
				     };
		BoxStackingProblem bsp= new BoxStackingProblem();
		List<Box> allBoxWays = bsp.getAllBoxWays(arr);
		Collections.sort(allBoxWays);
		bsp.getMaxHeight(allBoxWays);
		
	}

	private void getMaxHeight(List<Box> allBoxWays) {
		int max[] = new int[allBoxWays.size()];
		int result[] = new int[allBoxWays.size()];
		
		for(int i=0;i<allBoxWays.size();i++){
			max[i]=allBoxWays.get(i).h;
			result[i]=i;
		}
		
		for(int i=1;i<allBoxWays.size();i++){
			for(int j=0;j<i;j++){
				int lengthI = allBoxWays.get(i).l;
				int breathI = allBoxWays.get(i).b;	
				int heightI = allBoxWays.get(i).h;
				int lengthJ = allBoxWays.get(j).l;
				int breathJ = allBoxWays.get(j).b;	
				if(lengthI<lengthJ && breathI<breathJ){
					max[i]=max[j]+heightI;
					result[i]=j;
				}
			}
		}
		OptionalInt maxHeight = Arrays.stream(max).max();
		System.out.println(maxHeight);
	}

	private List<Box> getAllBoxWays(Box[] arr) {
		//evaluate total number of ways each box can be kept
		
		//1,2,3 ==> 1,2,3 ; 3,1,2 ; 2,3,1
		ArrayList<Box> boxWays= new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			Box box = arr[i];
			boxWays.add(new Box(box.l>box.b?box.l:box.b, box.l>box.b?box.b:box.l, box.h));
			int lbh[] = {box.l,box.b,box.h};
 			for (int j =1; j < 3; j++) {
 				int temp = lbh[0];
				for (int k = 1; k < lbh.length; k++) {
					int prev = lbh[k];
					lbh[k]=temp;
					temp=prev;
				}
				lbh[0]=temp;
				boxWays.add(new Box(lbh[0]>lbh[1]?lbh[0]:lbh[1], lbh[0]>lbh[1]?lbh[1]:lbh[0], lbh[2]));
			}
		}
		return boxWays;
	}
	
}
