package com.yardi.domain;

public abstract class Individual<T> {
	
	private String name;
	
	public abstract IndividualType getType();
	
	public abstract T performRole();

	public Individual(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}



}
