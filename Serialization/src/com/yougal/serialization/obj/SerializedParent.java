package com.yougal.serialization.obj;

import java.io.Serializable;

public class SerializedParent implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int age;
	
	private String name;
	
	public SerializedParent() {
		System.out.println("SerializedParent constructor");
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SerializedParent [age=" + age + ", name=" + name + "]";
	}
	
	
}
