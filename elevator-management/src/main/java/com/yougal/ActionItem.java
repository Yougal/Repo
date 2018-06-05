package com.yougal;

import com.yougal.impl.Lift;

public interface ActionItem {
	
	void doAction(Lift lift) throws Exception;
	
	Direction getActionDirection();
	
	int floor();

}
