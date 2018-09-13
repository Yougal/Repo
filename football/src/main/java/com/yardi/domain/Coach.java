package com.yardi.domain;

public class Coach extends Individual<GameStrategy> {
	
	
	private GameStrategy gameStrategy;

	public Coach(String name,GameStrategy gameStrategy) {
		super(name);
		
		this.gameStrategy=gameStrategy;
	}

	@Override
	public IndividualType getType() {
		return IndividualType.COACH;
	}

	@Override
	public GameStrategy performRole() {
		return gameStrategy;
		
	}	
}
