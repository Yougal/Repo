package com.yougal.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yougal.assembler.GameResourceAssembler;
import com.yougal.controller.GameController;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses= {GameController.class,InMemoryGameRepository.class,GameResourceAssembler.class})
public class GameConfiguration {

}
