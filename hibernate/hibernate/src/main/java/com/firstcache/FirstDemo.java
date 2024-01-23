package com.firstcache;

import javax.persistence.Cacheable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;

import com.framework.hibernate.Student;

public class FirstDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//by default enabled
		Student student = session.get(Student.class, 12424);
		System.out.println(student);
		
		System.out.println("working something..");
		
		Student student2 = session.get(Student.class, 12424); //this object comes from the cache itself.
		System.out.println(student2);
		
		System.out.println(session.contains(student2));  //true
		
		session.close();
		
		System.out.println(session.contains(student2)); //false
		
		factory.close();
	}

}
