package com.yougal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XPathRouterMain {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-xpath-router.xml");
		while (true) {
		}
	}
}
