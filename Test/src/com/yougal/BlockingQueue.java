package com.yougal;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class BlockingQueue<T> {
	
	private final LinkedList<T> queue;
	
	private final int maxSize;
	
	private PriorityQueue<TimedWrapper>  priorityQueue = new PriorityQueue<TimedWrapper>((o1,o2)->
																		(int)(o1.getTimeInMilliseconds()-o2.getTimeInMilliseconds()));
	
	private Object lock = new Object();

	public BlockingQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.queue = new LinkedList<T>();
	}
	
	public void push(T element) throws Exception{
		Thread t1 = Thread.currentThread();
		synchronized (t1) {
			if(queue.size()<=maxSize){
				queue.add(element);
			}else{
				//priorityQueue.add(timedWrapper);
				t1.wait();
			}
		}
	}
	
	
	private static class TimedWrapper{
		private final long timeInMilliseconds;

		public TimedWrapper(long timeInMilliseconds) {
			super();
			this.timeInMilliseconds = timeInMilliseconds;
		}

		/**
		 * @return the timeInMilliseconds
		 */
		public long getTimeInMilliseconds() {
			return timeInMilliseconds;
		}
	}
	

}
