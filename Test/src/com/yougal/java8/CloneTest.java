package com.yougal.java8;

public class CloneTest {
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Parent parent = new  Parent(6);
		System.out.println(parent.hashCode());
		System.out.println(parent.clone().hashCode());
	}
	

}

class Parent implements Cloneable{
	int x;

	public Parent(int x) {
		super();
		this.x = x;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parent [x=" + x + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
