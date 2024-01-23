package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Person person = new Person(23, "Ram", "Delhi", "52524");
		
		Transaction transaction = session.beginTransaction();
		
		session.save(person);
				
		transaction.commit();
		session.close();
		factory.close();

	}

}
