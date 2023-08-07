package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
		
		// the bean name ("student") we wrote is the name of the Student class in camel case
		// or we can change the name to something else, but the same name should be inside @Component("ob") == context.getBean("ob",Student.class)
		Student student = context.getBean("student", Student.class);
		
		System.out.println(student);
		
		System.out.println(student.getAddress());
		System.out.println(student.getAddress().getClass().getName());
	
		System.out.println("-----------------------------------------------");
		
		// the spring container gives the same object that's already created, so these two objects are same - this is singleton bean scope
		// Types of bean scope - Singleton, prototype, request, session, globalsession
		// prototype means - everytime a new object will be created by spring container and give it to us
		
		System.out.println(student.hashCode());
		
		Student student2 = context.getBean("student",Student.class);
		System.out.println(student2.hashCode());
		
		Teacher t1  = context.getBean("teacher",Teacher.class);
		Teacher t2 = context.getBean("teacher",Teacher.class);
		System.out.println(t1.hashCode()+" "+t2.hashCode());
	}

}
