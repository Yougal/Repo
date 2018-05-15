package com.yougal.impl;

import com.yougal.ActionItem;
import com.yougal.Direction;
import com.yougal.State;

public class LiftOpenAction implements ActionItem {

	int currentFloor;
	
	public LiftOpenAction(int currentFloor) {
		this.currentFloor=currentFloor;
	}

	@Override
	public void doAction(Lift lift) {
		try{
			lift.setLiftState(State.DOOR_OPEN);
			System.out.println("Opened Lift at Floor: "+ currentFloor);
			Thread.sleep(2000);
		}catch(Exception ex){
			// do nothing
		}
	}

	@Override
	public Direction getActionDirection() {
		return null;
	}

	@Override
	public int floor() {
		// TODO Auto-generated method stub
		return currentFloor;
	}

}
