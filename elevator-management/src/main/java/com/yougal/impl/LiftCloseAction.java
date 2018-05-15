package com.yougal.impl;

import com.yougal.ActionItem;
import com.yougal.Direction;
import com.yougal.State;

public class LiftCloseAction implements ActionItem {

	int floorToCloseDoor;
	
	public LiftCloseAction(int floor) {
		this.floorToCloseDoor =floor;
	}

	@Override
	public void doAction(Lift lift) {
		try{
			System.out.println("Closing Lift at Floor: "+ floorToCloseDoor);
			Thread.sleep(2000);
			lift.setLiftState(State.DOOR_CLOSED);
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
		return floorToCloseDoor;
	}

}
