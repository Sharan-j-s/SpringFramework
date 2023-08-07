package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		
		// see application context we are creating different object for this
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Student student  = context.getBean("student",Student.class);
		
		System.out.println(student);
		
		student.study();
		
	}

}
