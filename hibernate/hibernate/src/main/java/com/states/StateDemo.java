package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.framework.hibernate.Certificate;
import com.framework.hibernate.Student;

public class StateDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Creating student object
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		//student : Transient
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		//student : Persistent - associated with both session & database both
		student.setName("John");
		
		transaction.commit();
		
		session.close();		
		//student : Detached
		student.setName("Sachin");
		
		System.out.println(student);
		
		factory.close();
		
	}
}
