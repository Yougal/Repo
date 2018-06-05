package com.mkyong.common.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) throws Exception { 
		SpringApplication.run(Application.class, args);
		
		
	}
	
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}