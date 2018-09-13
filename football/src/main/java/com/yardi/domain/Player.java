package com.yardi.domain;

public class Player extends Individual<String> {
	
	private String role;

	public Player(String name,String role) {
		super(name);
		this.role=role;
		// TODO Auto-generated constructor stub
	}

	@Override
	public IndividualType getType() {
		// TODO Auto-generated method stub
		return IndividualType.PLAYER;
	}

	@Override
	public String performRole() {
		//System.out.println("I am in " + getName());
		// TODO Auto-generated method stub
		return role;
		
	}

}

