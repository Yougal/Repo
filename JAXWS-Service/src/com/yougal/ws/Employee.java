package com.yougal.ws;

public class Employee {

	private String name;
	
	private Integer id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Employee(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
