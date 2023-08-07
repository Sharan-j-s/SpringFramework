package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		// Implementing LifeCycle methods of spring bean using XML
		
		// to call shutdownhook we need AbstractApplicationContext
		
		AbstractApplicationContext context	= new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
		
		Samosa s1 = (Samosa) context.getBean("s1");
		
		System.out.println(s1);
		
		// inorder to call destroy method we need registerShutdownHook() 
		// registering shutdownhook
		context.registerShutdownHook();
		
		System.out.println(" --------------------------------------------------------------- ");
		
		// Implementing Bean Lifecycle using interfaces InitializingBean & DisposableBean
		
		Pepsi p1 = (Pepsi) context.getBean("p1");
		System.out.println(p1);
		
		System.out.println(" --------------------------------------------------------------- ");
		
		// Implementing Bean LifeCycle using Annotations @PostConstruct @PreDestroy
		
		Example example = (Example) context.getBean("example");
		System.out.println(example);
		
		

	}

}
