package com.yougal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlToObjectTransformerMain {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-xml-transformer.xml");
		while (true) {
		}
	}
}
