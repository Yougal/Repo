package com.mkyong.core;

import javax.annotation.PostConstruct;

public class A {

	//@Autowired
	private B b;
	
	public A (){
	}
	
	public A (B b){
		this.b =b;
	}
	
	@PostConstruct
	public void display(){
		System.out.println(b.hashCode());
	}

	/**
	 * @return the b
	 */
	public B getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}
	
}
