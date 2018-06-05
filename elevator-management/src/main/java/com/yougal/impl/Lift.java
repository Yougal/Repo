package com.yougal.impl;

import java.util.concurrent.Semaphore;

import com.yougal.ActionItem;
import com.yougal.Direction;
import com.yougal.LiftOperation;
import com.yougal.State;

public class Lift implements LiftOperation,Runnable{

	private Direction directionLiftIsGoing;
	
	private int currentFloor;
	
	private int maxFloor;
	
	private int minFloor;
	
	private State liftState;
	
	private LiftActionQueue liftActionQueue = new LiftActionQueue();
	
	private Semaphore lock = new Semaphore(1);
	
	private boolean isStopped;

	private int currenTargetFloor;
	
	@Override
	public void moveLift(int floor) throws Exception {
		if(floor<minFloor || floor>maxFloor){
			throw new UnsupportedOperationException("Invalid Floor Pressed");
		}
		try{
			lock.acquire();
			addItemInQueue(new LiftMoveAction(floor,getDirection(floor)));
		}finally{
			lock.release();
		}
		

	}

	private Direction getDirection(int floor) {
		if(directionLiftIsGoing==Direction.UP){
			if(currentFloor>floor){
				return Direction.UP;
			}else{
				return Direction.DOWN;
			}
		}else{
			if(floor<currentFloor){
				return Direction.DOWN;
			}else{
				return Direction.UP;
			}
		}
	}

	@Override
	public void callLift(int floor, Direction directionToGo) throws Exception {
		if(floor<minFloor || floor>maxFloor){
			throw new UnsupportedOperationException("Invalid Floor Pressed");
		}
		try{
			lock.acquire();
			addItemInQueue(new LiftMoveAction(floor,directionToGo));
		}finally{
			lock.release();
		}
	}

	@Override
	public void openLift()  throws Exception{
		try{
			lock.acquire();
			addItemInQueue(new LiftOpenAction(currentFloor));
		}finally{
			lock.release();
		}
	}

	@Override
	public void closeLift()  throws Exception{
		try{
			lock.acquire();
			addItemInQueue(new LiftCloseAction(currentFloor));
		}finally{
			lock.release();
		}
	}

	@Override
	public void startLift() throws Exception {
		Thread t1= new Thread(this);
		t1.start();
		t1.join();
	}

	@Override
	public void run() {
		while(!isStopped){
			while(!liftActionQueue.hasItems());
			
			ActionItem actionItem = liftActionQueue.getAction();
			try {
				currenTargetFloor=actionItem.floor();
				actionItem.doAction(this);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}

	@Override
	public void stopLift() throws Exception {
		liftActionQueue.doNotAcceptAnyAction();
	}
	
	
	private void addItemInQueue(ActionItem newActionItem){
		if(liftState!=State.STATIONARY){
			if(currenTargetFloor
		}else{
			liftActionQueue.addAction(newActionItem);
		}
	}

	/**
	 * @return the liftState
	 */
	public State getLiftState() {
		return liftState;
	}

	/**
	 * @param liftState the liftState to set
	 */
	public void setLiftState(State liftState) {
		this.liftState = liftState;
	}

	/**
	 * @return the directionLiftIsGoing
	 */
	public Direction getDirectionLiftIsGoing() {
		return directionLiftIsGoing;
	}

	/**
	 * @param directionLiftIsGoing the directionLiftIsGoing to set
	 */
	public void setDirectionLiftIsGoing(Direction directionLiftIsGoing) {
		this.directionLiftIsGoing = directionLiftIsGoing;
	}

	/**
	 * @return the currentFloor
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}

	/**
	 * @param currentFloor the currentFloor to set
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	
}
