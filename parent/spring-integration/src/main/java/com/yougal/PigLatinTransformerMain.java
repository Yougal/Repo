package com.yougal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PigLatinTransformerMain {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-pig-latin-transformer.xml");
		while (true) {
		}
	}
}
