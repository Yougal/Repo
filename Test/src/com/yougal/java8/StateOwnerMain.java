package com.yougal.java8;

public class StateOwnerMain {
		public static void main(String[] args) {
			StateOwner stateOwner1 = new StateOwner();
			
			
			
			
			//java 7 way
			stateOwner1.addStateListener(new StateChangeListener() {

			    public void onStateChange(State oldState, State newState) {
			        // do something with the old and new state.
			    }
			});
			
			
			
			//java 8 way
			stateOwner1.addStateListener((State oldState, State newState)->System.out.println("State Changed"));
			
		}
}
