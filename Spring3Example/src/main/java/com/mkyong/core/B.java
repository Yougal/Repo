package com.mkyong.core;

import javax.annotation.PostConstruct;

public class B {

	//@Autowired
	private C c;
	
	public B (){
	}
	
	public B (C c){
		this.c=c;
	}
	
	@PostConstruct
	public void display(){
		System.out.println(c.hashCode());
	}

	/**
	 * @return the a
	 */
	public C getC() {
		return c;
	}

	/**
	 * @param a the a to set
	 */
	public void setC(C c) {
		this.c = c;
	}
	
	
}
