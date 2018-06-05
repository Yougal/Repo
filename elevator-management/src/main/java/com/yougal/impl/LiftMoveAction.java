package com.yougal.impl;

import com.yougal.ActionItem;
import com.yougal.Direction;
import com.yougal.State;

public class LiftMoveAction implements ActionItem{

	int floorToMoveLift;
	
	Direction direction;
	
	LiftOpenAction liftOpenAction;
	
	LiftCloseAction liftCloseAction;
	
	LiftMoveAction(int floorToMove, Direction direction){
		this.floorToMoveLift =floorToMove;
		this.direction=direction;
		this.liftOpenAction=new LiftOpenAction(floorToMove);
		this.liftCloseAction = new LiftCloseAction(floorToMove);
	}
	
	
	@Override
	public void doAction(Lift lift) throws Exception {
		liftOpenAction.doAction(lift);
		lift.setLiftState(State.MOVING);
		Thread.sleep(5000);
		liftCloseAction.doAction(lift);
		lift.setLiftState(State.STATIONARY);
	}


	@Override
	public Direction getActionDirection() {
		return direction;
	}


	@Override
	public int floor() {
		return floorToMoveLift;
	}

}
