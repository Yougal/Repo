package com.yougal.si.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yougal.si.transformers.PigLatinTransformer;

@Configuration
public class SpringConfiguration {

	@Bean(name="pigLatinTransformer")
	public PigLatinTransformer getObject() {
		return new PigLatinTransformer();
	}
	
}
