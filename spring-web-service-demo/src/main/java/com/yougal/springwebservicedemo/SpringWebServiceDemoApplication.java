package com.yougal.springwebservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yougal.springwebservicedemo.configuration.CustomerManagementConfiguration;

@SpringBootApplication
public class SpringWebServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementConfiguration.class, args);
	}
}
