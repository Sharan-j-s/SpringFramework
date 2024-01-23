package com.pegination;

import org.hibernate.query.*;

import com.framework.hibernate.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Student");
		
		
		//Implementing pegination using hibernate
		query.setFirstResult(0); //start index
		query.setMaxResults(5); // the number of results in a page
		
		List<Student> list = query.list();
		for(Student s : list)
			System.out.println(s.getId()+" : "+s.getName()+" : "+s.getCity());
		
		session.close();
		factory.close();
	}

}
