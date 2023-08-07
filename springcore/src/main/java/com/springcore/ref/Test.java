package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		// this is an example for how to perform reference inject
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ref/refconfig.xml");
		
		A temp = (A) context.getBean("aref");
		System.out.println(temp.getX());
		
		// getting value of object b from object a, check xml file
		System.out.println(temp.getOb().getY());
		
		System.out.println(temp);
	}

}
