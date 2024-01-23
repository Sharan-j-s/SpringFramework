package com.mapmany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Emp emp1 = new Emp();
		Emp emp2 = new Emp();
		
		emp1.setEid(34);
		emp1.setName("Ram");		
		emp2.setEid(35);
		emp2.setName("Shyam");
		
		Project project1 = new Project();
		Project project2 = new Project();
		
		project1.setPid(12121);
		project1.setProjectName("Library Management System");
		project2.setPid(14214);
		project2.setProjectName("CHATBOT");
		
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		
		list2.add(project1);
		list2.add(project2);
		
		emp1.setProjects(list2);
		project2.setEmps(list1);
		
		Session session = factory.openSession();
		Transaction txTransaction = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(project1);
		session.save(project2);	
		
		txTransaction.commit();
		
		factory.close();

	}

}
