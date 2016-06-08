package com.yougal.java8;

class Student18 implements Cloneable {
	int rollno;
	String name;

	private Address address;
	
	Student18(int rollno, String name,Address address) {
		this.rollno = rollno;
		this.name = name;
		this.address=address;
	}

	public Object clone() throws CloneNotSupportedException {
		Student18 c = (Student18) super.clone();
		c.address=(Address)(c.address.clone());
		return c;
	}

	public static void main(String args[]) {
		try {
			Student18 s1 = new Student18(101, "amit",new Address("Ghar 1"));

			Student18 s2 = (Student18) s1.clone();

			System.out.println(s1.rollno + " " + s1.name + " " + s1.address);
			System.out.println(s2.rollno + " " + s2.name + " " + s2.address);

		} catch (CloneNotSupportedException c) {
			throw new RuntimeException(c);
		}

	}
	
	
}

class Address implements Cloneable{
	
	String addressString;

	public Address(String addressString) {
		super();
		this.addressString = addressString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressString=" + addressString + ", hashCode()=" + hashCode() + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}