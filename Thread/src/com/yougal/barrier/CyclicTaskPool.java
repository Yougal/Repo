package com.yougal.barrier;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
/**
 * Launches same number of Thread as number of Task 
 * but is run in cycles until the task are finished
 * 
 * @author yougal.bisht
 *
 */
public class CyclicTaskPool extends AbstractThreadPool{

	private List<List<Task>> tasksToProcess;
	
	private  CyclicBarrier barrier;
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	private int index=0;
	
	public CyclicTaskPool(List<List<Task>> tasksToProcess,int size){
		this.tasksToProcess = tasksToProcess;
		barrier = new CyclicBarrier(size, new Runnable() {
			@Override
			public void run() {
				index++;
				if(index>tasksToProcess.size()) {
					barrier.reset();
				}else {
					latch.countDown();
				}
			}
		});
	}
	
	@Override
	protected void initiateThreadPool(int size) {
		 for (int i = 0; i < size; ++i) 
             new Thread(makeWorker(i)).start();
	}

	@Override
	protected List<Task> getTasks() {
		return tasksToProcess.get(index);
	}

	@Override
	protected void awaitThreadPoolDone() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doWorkInBackground(Task inputData) {
		inputData.process();
	}
	
	protected boolean advanceToNextCycle() {
		try {
			barrier.await();
			return index<tasksToProcess.size();
		} catch (InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
