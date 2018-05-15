package com.yougal;

public interface LiftOperation {
	
	void startLift() throws Exception;
	
	void stopLift() throws Exception;
	
	void moveLift(int floor) throws Exception;

	void callLift(int floor,Direction directionToGo) throws Exception ;
	
	void openLift() throws Exception;
	
	void closeLift() throws Exception;
	
}
