package com.yougal.serialization.obj;

public class NonSerializedParent {

	public NonSerializedParent() {
		super();
		System.out.println("NonSerializedParent constructor");
	}

	private int age;
	
	private String name;

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
		return "NonSerializedParent [age=" + age + ", name=" + name + "]";
	}
	
	
}
