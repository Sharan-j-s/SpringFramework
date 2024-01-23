package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.framework.hibernate.Student;

public class CriteriaApiExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria c = session.createCriteria(Student.class);
		
		//c.add(Restrictions.eq("certi.course","Android")); //we can add filter here
		//c.add(Restrictions.likke("certi.course","Java%"));
		c.add(Restrictions.gt("id",24)); //another filter - id > 24
		
		List<Student> students = c.list();
		for(Student st : students)
			System.out.println(st);
		
		session.close();

	}

}
