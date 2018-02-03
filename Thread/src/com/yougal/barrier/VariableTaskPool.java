package com.yougal.barrier;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
/**
 * Launches variable number of Thread as number of Task 
 * but is run in cycles until the task are finished
 * 
 * @author yougal.bisht
 *
 */
public class VariableTaskPool extends AbstractThreadPool{

	private List<List<Task>> tasksToProcess;
	
	private Phaser phaser;
	
	private CountDownLatch exitLatch = new CountDownLatch(1);
	
	private int cycle=0;
	
	private  CyclicBarrier barrier;
	
	public VariableTaskPool(List<List<Task>> tasksToProcess,int iterations){
		this.tasksToProcess = tasksToProcess;
		this.phaser = new Phaser(getTasks().size()) {
		     protected boolean onAdvance(int phase, int registeredParties) {
		    	 barrier = new CyclicBarrier(getTasks().size(), new Runnable() {
					@Override
					public void run() {
					 	cycle++;
						if(cycle<tasksToProcess.size()) {
							int oldCountThreadCount = tasksToProcess.get(cycle-1).size();
							int newThreadCount = tasksToProcess.get(cycle).size();
							if(oldCountThreadCount!=newThreadCount) {
								if(newThreadCount>oldCountThreadCount) {
									for(int i=oldCountThreadCount;i<newThreadCount;i++) {
										 phaser.register();
										 new Thread(makeWorker(i)).start();
									}
								}
							}
						}
					}
				});
		         return phase+1 >= iterations || registeredParties == 0;
		       }
		     };
	}
	
	@Override
	protected void initiateThreadPool(int size) {
		 for (int i = 0; i < size; ++i) {
             new Thread(makeWorker(i)).start();
		 }
	}

	@Override
	protected List<Task> getTasks() {
		return tasksToProcess.get(cycle);
	}

	@Override
	protected void awaitThreadPoolDone() {
		try {
			exitLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doWorkInBackground(Task inputData) {
		inputData.process();
	}
	@Override
	protected boolean workerDone(int index){
		phaser.arriveAndAwaitAdvance();
		try {
			barrier.await();
			boolean shouldContinueWithThisThread = phaser.isTerminated() || index>=getTasks().size();
			if(shouldContinueWithThisThread) {
				phaser.arriveAndDeregister();
			}
			return shouldContinueWithThisThread;
		} catch (InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected boolean advanceToNextCycle() {
		boolean shouldMoveToNextCycle = !phaser.isTerminated();
		if(!shouldMoveToNextCycle) {
			exitLatch.countDown();
		}
		return shouldMoveToNextCycle;
	}

}
