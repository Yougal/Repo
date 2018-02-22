package com.yougal.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.yougal.config.PlainJpaConfig;
import com.yougal.model.Customer;
import com.yougal.repository.CustomerRepository;

@SpringBootApplication
@ComponentScan(basePackageClasses=PlainJpaConfig.class)
public class JpaApplication {

	public static void main(String[] args) throws Exception {
		 SpringApplication springApplication = new SpringApplication();
		 ApplicationContext ctx = springApplication.run(JpaApplication.class, args);
		 CustomerRepository customerRepository = ctx.getBean(CustomerRepository.class);
		 Customer c = customerRepository.findById(1l);
		 System.out.println(c);
	}

}