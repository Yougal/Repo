package com.yougal.si.configuration.dsl.java8;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;

@Configuration
@IntegrationComponentScan
public class SIComponents {
	
	@Autowired
	Cafe cafe ;
	
	@Bean
	public SIComponents getBean(){
		return new SIComponents();
	}

	 public static void main(String[] args) throws Exception {
		 	Scanner sc = new Scanner(System.in);
		  	Cafe cafe = new SIComponents().cafe;                         // 4
		  	for (int i = 1; i <= 100; i++) {   
		  		String s = sc.nextLine();
		  		cafe.placeOrder(s);
		  	}
		  	sc.close();
		  }

		  @MessagingGateway                                              // 7
		  public interface Cafe {

		  	@Gateway(requestChannel = "inputChannel")                    // 8
		  	void placeOrder(String input);                                // 9

		  }

		  @Bean(name = PollerMetadata.DEFAULT_POLLER)
		  public PollerMetadata poller() {                               // 11
		  	return Pollers.fixedDelay(1000).get();
		  }

		  @Bean
		  public IntegrationFlow inputChannel() {                             // 12
		  	return f -> f.channel("");                                           // 13
		  }

		}
