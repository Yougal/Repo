package com.yougal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnricherMain {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-xml-enricher.xml");
		while (true) {
		}
	}
}
