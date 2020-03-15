package com.yougal.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Result {
	

    public static long teamFormation(List<Integer> score, int team_size, int k) {
       List<Integer> indexes = new ArrayList<>();
       for (int i=0;i<score.size(); i++) {
    	   indexes.add(i);
       }
       PriorityQueue<Integer> kStartElementHeap = new PriorityQueue<>(new Comparator<Integer>() {
               public int compare(Integer o1, Integer o2){
                   return score.get(o2) -score.get(o1);
               }
           });
       PriorityQueue<Integer> kEndElementHeap = new PriorityQueue<>(new Comparator<Integer>() {
               public int compare(Integer o1, Integer o2){
                   return score.get(o2) -score.get(o1);
               }
           });
       for(int i=0;i<k;i++){
           kStartElementHeap.offer(i);
           kEndElementHeap.offer(indexes.size()-i-1);
       }
       int sum=0;
        while(team_size>0){
            int index1 = kStartElementHeap.peek();
            int index2 = kEndElementHeap.peek();
            Integer value2 = score.get(index2);
			if(index1==index2){
                sum+=value2;
                System.out.println(value2);
                indexes.remove(new Integer(index1));
                kEndElementHeap.remove();
                kStartElementHeap.remove();
                if(indexes.size()>k) {
	                kStartElementHeap.offer(indexes.get(k-1));
	                kEndElementHeap.offer(indexes.get(indexes.size()-k-1));
                }else {
                	
                }
            } else {
				Integer value1 = score.get(index1);
				if(value2>value1){
				    sum+=value2;
				    System.out.println(value2);
				    indexes.remove(new Integer(index2));
				    kEndElementHeap.remove();
				    if(indexes.size()>k) {
				    	kEndElementHeap.offer(indexes.get(indexes.size()-k-1));
				    }else {
				    	kEndElementHeap.offer(indexes.get(0));
				    }
				}else{
				    sum+=value1;
				    System.out.println(value1);
				    indexes.remove(new Integer(index1));
				    kStartElementHeap.remove();
				    if(indexes.size()>k) {
				    	kStartElementHeap.offer(indexes.get(k-1));
				    }else {
					    kStartElementHeap.offer(indexes.get(indexes.size()-1));
				    }
				}
			}
			
            team_size--;
        }
        return sum;

    }
	   
	   public static void main(String[] args) {
		Integer reduce = Arrays.asList(6,18,8,14,10,12,18,9).stream().reduce(0, (a,b)->a+b);
		System.out.println(reduce);
		System.out.println(teamFormation(Arrays.asList(6,18,8,14,10,12,18,9), 8,3));
	}

}
