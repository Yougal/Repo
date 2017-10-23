package com.yougal.string;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeCharacters {

	public static void main(String[] args) {
		 String str = "aaabc" ;
		 rearrangeString(str);
		 str = "aaabb" ;
		 rearrangeString(str);
		 str = "aa" ;
		 rearrangeString(str);
		 str = "aaaabc" ;
		 rearrangeString(str);
	}

	private static void rearrangeString(String str) {
		StringBuilder result = new StringBuilder();
		PriorityQueue<Entry<Character,Integer>> heap = new PriorityQueue<>((a,b)-> {
			int comp = b.getValue()-a.getValue();
			if(comp==0){
				comp=b.getKey().compareTo(a.getKey());
			}
			return comp;	
		});	
		int a[] = new int[256];
		for(int i=0;i<str.length();i++){
			a[str.charAt(i)]=a[str.charAt(i)]+1;
		}
		
		for (int i=0;i<a.length;i++) {
			int freq = a[i];
			if(freq>0){
				char c = (char)i;
				heap.add(new SimpleEntry<Character,Integer>(c,freq));
			}
		}
		
		while(!heap.isEmpty()){
			Entry<Character,Integer> first = heap.poll();
			if(first.getValue()>1){
				if(heap.isEmpty()){
					System.out.println("No Arrangement Possible...");
					return;
				}else{
					Entry<Character,Integer> second = heap.poll();
					result.append(first.getKey());
					result.append(second.getKey());
					if(first.getValue()-1>0){
						heap.add(new SimpleEntry<Character,Integer>(first.getKey(),first.getValue()-1));
					}
					if(second.getValue()-1>0){
						heap.add(new SimpleEntry<Character,Integer>(second.getKey(),second.getValue()-1));
					}
				}
			}else{
				result.append(first.getKey());
			}
		}
		
		System.out.println(result.toString());
		
		
	}
	
}
