package com.mkyong.core;

import javax.annotation.PostConstruct;

public class C {

	//@Autowired
	private A a;
	
	public C (){
	}
	
	public C (A a){
		this.a =a;
	}
	
	@PostConstruct
	public void display(){
		System.out.println(a.hashCode());
	}

	/**
	 * @return the b
	 */
	public A getA() {
		return a;
	}

	/**
	 * @param b the b to set
	 */
	public void setA(A a) {
		this.a = a;
	}
	
}
