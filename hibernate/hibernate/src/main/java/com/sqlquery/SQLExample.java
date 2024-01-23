package com.sqlquery;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.framework.hibernate.Student;

public class SQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//SQL Query
		String query = "select * from student";
		
		NativeQuery nq = session.createSQLQuery(query);
		
		List<Object[]> list = nq.list();
		
		for(Object[] student : list)
			System.out.println(Arrays.toString(student)); //Arrays.deepToString() can also be used
		
		session.close();
		factory.close();

	}

}
