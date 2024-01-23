package com.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapp.many.*;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Question question1 = new Question();
		
		question1.setQuestionId(567);
		question1.setQuestion("What is cascadeing?");
		
		
		Answer a1 = new Answer(23423, "In hibernate it is important concept");
		Answer a2 = new Answer(255, "Second answer");
		Answer a3 = new Answer(35, "third answer");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		question1.setAnswers(list);
		
		Transaction transaction = session.beginTransaction();
		
		session.save(question1);
		
//		If we give cascade = CascadeType.ALL in question class, no need to save these answers specifically
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		
		transaction.commit();
		session.close();
		factory.close();

	}

}
