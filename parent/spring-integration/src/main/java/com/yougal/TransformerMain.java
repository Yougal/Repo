package com.yougal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransformerMain {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-transformer.xml");
		while (true) {
		}
	}
}
