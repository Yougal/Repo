package com.yougal.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInfiniteStream {

	static PriorityQueue<Integer> elementLessThan = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> elementGreaterThan = new PriorityQueue<>();

	public static void main(String[] args) {
		 int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		    // In lieu of A, we can also use data read from a stream
		 Arrays.stream(A).forEach(f->printMedian(f));
	}

	private static void printMedian(int element) {
		if(elementLessThan.size()==elementGreaterThan.size()){
			if(elementLessThan.size()==0){
				elementLessThan.offer(element);
			}else{
				if(element<elementLessThan.peek()){
					elementLessThan.offer(element);
				}else{
					elementGreaterThan.offer(element);
				}
			}
		}else{
			/**
			 * 1. find smaller heap
			 * 2. check element with heap Property
			 * 3. if breaks then extract element from other heap and insert it to smaller heap and insert element in other heap
			 * 4. if not breaks insert it to smaller heap
			 */
			int heapProperty = 0;
			if(elementLessThan.size()>elementGreaterThan.size()){
				heapProperty =1 ;
			}else{
				heapProperty =0 ;
			}
			
			if(heapProperty==1){
				if(elementGreaterThan.size()==0 || element> elementGreaterThan.peek()){
					elementGreaterThan.offer(element);
				}else{
					shuffleAndInsert(elementGreaterThan, elementLessThan, element);
				}
			}else{
				if(elementLessThan.size()==0 ||  element<elementLessThan.peek()){
					elementLessThan.offer(element);
				}else{
					shuffleAndInsert(elementLessThan, elementGreaterThan, element);
				}
			}
			
		}
		
		if(elementLessThan.size()==elementGreaterThan.size()){
			System.out.println((elementLessThan.peek() + elementGreaterThan.peek())/2.0);
		}else{
			if(elementLessThan.size()>elementGreaterThan.size()){
				System.out.println(elementLessThan.peek());
			}else{
				System.out.println(elementGreaterThan.peek());
			}
		}
		
	}

	private static void shuffleAndInsert(PriorityQueue<Integer> smallerHeap,PriorityQueue<Integer> biggerHeap, int element ) {
		int elementToShuffle = biggerHeap.remove();
		smallerHeap.offer(elementToShuffle);
		biggerHeap.offer(element);
	}
}
