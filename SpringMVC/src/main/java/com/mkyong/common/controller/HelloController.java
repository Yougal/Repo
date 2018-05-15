package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelAndView modelAndView) {

		modelAndView.addObject("message", "Spring 3 MVC Hello World");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	
}