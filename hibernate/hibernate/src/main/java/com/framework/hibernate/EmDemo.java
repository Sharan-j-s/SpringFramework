package com.framework.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(14134);
		student1.setName("Anikit Tiwari");
		student1.setCity("LKO");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(1212);
		student2.setName("Ravi Tiwari");
		student2.setCity("DELHI");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 months");
		student2.setCerti(certificate1);
		
		
		Session session = factory.openSession();
		Transaction txTransaction = session.beginTransaction();
		
		//objects save:
		session.save(student1);
		session.save(student2);
		txTransaction.commit();
		
		session.close();		
		factory.close();
	}

}
