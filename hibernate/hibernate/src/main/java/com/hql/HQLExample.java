package com.hql;

import java.util.Arrays;
import java.util.List;


import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.framework.hibernate.Student;

public class HQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//HQL Syntax - Select
		String query = "from Student";
		String query2 = "from Student where city='Lucknow'";
		String query3 = "from Student where city=:x"; //we can set parameter for x via q
		String query4 = "from Student as s where s.city=:x and s.name=:n";
		
		
		Query q	= session.createQuery(query);
		
		q.setParameter("x", "Lucknow"); //setting param for x here. [we can also get this from user input].
		
		//From query we may expect single(unique) or multiple(list) result
		List<Student> list = q.list();
		
		for(Student student : list)
			System.out.println(student.getName());
		
		//Delete
		Transaction tx = session.beginTransaction();		
		String query5 = "delete from Student s where s.city=:c";
		q.setParameter("c", "Lucknow");
		int r = q.executeUpdate();  //it returns no of entities deleted or updated
		System.out.println("Deleted:");
		System.out.println(r);
		tx.commit();
		
		//Update
		Transaction tx2 = session.beginTransaction();	
		String query6 = "update Student set city=:c where name=:n";
		q.setParameter("c", "Delhi");
		q.setParameter("n", "Peter");
		int r2 = q.executeUpdate();
		System.out.println(r2+" objects updated");
		tx2.commit();
		
		//Join query
		String query7 = "select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a";
		List<Object []> list3 = q.getResultList();
		for(Object[] arr : list3)
			System.out.println(Arrays.toString(arr));
		
		session.close();
		factory.close();

	}

}
