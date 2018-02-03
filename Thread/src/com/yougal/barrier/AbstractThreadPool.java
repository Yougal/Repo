package com.yougal.barrier;

import java.util.List;

public abstract class AbstractThreadPool implements Runnable{
	
    protected abstract List<Task> getTasks();
	
	@Override
    public void run() {
        initiateThreadPool(getTasks().size());
        awaitThreadPoolDone();
    }

	protected abstract void  awaitThreadPoolDone();

	protected abstract void initiateThreadPool(int size);

	protected Runnable makeWorker(final int index) {
	        return new Runnable() {
	            public void run() {
	            	try {
	                do {
	                		
                    			Task element = getTasks().get(index);
                    			doWorkInBackground(element);
		                    if(workerDone(index)) {
		                	  	   return;
		                      }
	                    // Keep running until instructed to stop.
	                } while (advanceToNextCycle());
	            	}catch(Exception e) {
	            		e.printStackTrace();
	            		return ;
	            	}
	            }
	        };
	}
	
	protected boolean workerDone(int index){
		return false;
    }
    
    public abstract void doWorkInBackground(Task inputData);

    protected boolean advanceToNextCycle() {
        return false;
    }
}
