package com.framework.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String []args)
	{
		//get, load
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		// load-student:106 == 106 is id of the student. here we can use get also
		Student student = (Student)session.load(Student.class, 106);
		System.out.println(student);
		
		Address address = session.get(Address.class, 2);
		System.out.println(address.getCity()+" "+address.getAddeDate());
		
		
		session.close();
		factory.close();
	}

}
