package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.framework.hibernate.Student;

//for second level caching, we need  to download jar file from maven.
// search ehcache maven in google, get the jar file from mvnrepo, check pom.xml
// search hibernate cache maven in google, get the jar, check pom.xml. The version should be same as hibernate core 5.3.34
// Also check hibernate.cfg.xml, we've added some new properties to enable second level caching.
// Check Student class in com.framework.hibernate. We've added two new annotations, @Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
		
public class SecondCacheExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//first
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class, 103);
		System.out.println(student1);
		session1.close();
		
		//second
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 103);
		System.out.println(student2);
		session2.close();
		
		

	}

}
