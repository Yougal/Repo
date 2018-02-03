package com.yougal.barrier;

import java.util.List;
import java.util.concurrent.CountDownLatch;
/**
 * Launches same number of Thread as number of Task
 * 
 * @author yougal.bisht
 *
 */
public class OneTimeTaskPool extends AbstractThreadPool{

	private List<Task> tasksToProcess;
	
	private  CountDownLatch barrier;
	
	public OneTimeTaskPool(List<Task> tasksToProcess){
		this.tasksToProcess = tasksToProcess;
		barrier = new CountDownLatch(tasksToProcess.size());
	}
	
	@Override
	protected void initiateThreadPool(int size) {
		 for (int i = 0; i < size; ++i) 
             new Thread(makeWorker(i)).start();
	}

	@Override
	protected List<Task> getTasks() {
		return tasksToProcess;
	}

	@Override
	protected void awaitThreadPoolDone() {
		try {
			barrier.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doWorkInBackground(Task inputData) {
		barrier.countDown();
		inputData.process();
	}

	
	
}
