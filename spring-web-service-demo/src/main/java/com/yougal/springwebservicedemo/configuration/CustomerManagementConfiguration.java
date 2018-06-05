package com.yougal.springwebservicedemo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.yougal.springwebservicedemo.endpoint.CustomerDetailEndpoint;

@EnableWs
@EnableAutoConfiguration
@ComponentScan(basePackageClasses=CustomerDetailEndpoint.class)
public class CustomerManagementConfiguration {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
	  MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
	  messageDispatcherServlet.setApplicationContext(context);
	  messageDispatcherServlet.setTransformWsdlLocations(true);
	  return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
	}
	
	@Bean("customers")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema customerSchema) {
	  DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
	  definition.setPortTypeName("CustomerPort");
	  definition.setTargetNamespace("http://www.yougal.com/schema/CRM");
	  definition.setLocationUri("/ws/CustomerService");
	  definition.setSchema(customerSchema);
	  return definition;
	}
	
	@Bean("customerSchema")
	public XsdSchema studentsSchema() {
	  return new SimpleXsdSchema(new ClassPathResource("META-INF/CRM.xsd"));
	}

	
}
