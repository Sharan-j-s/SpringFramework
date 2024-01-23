package com.mapp.many;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating question
		Question question = new Question();
		question.setQuestionId(1212);
		question.setQuestion("What is Java?");

		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(question);

		
		Answer answer1 = new Answer();
		answer1.setAnswerId(33);
		answer1.setAnswer("With the help of java we can create softwares");
		answer1.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(363);
		answer2.setAnswer("Java has different types of frameworks.");
		answer2.setQuestion(question);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		question.setAnswers(list);
		
		
		// session
		Session session = factory.openSession();
		Transaction txTransaction = session.beginTransaction();
		
		session.save(question);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);
		
		txTransaction.commit();
		
		
		//fetching...
		Question newQuestion = session.get(Question.class, 1212);
		System.out.println(newQuestion.getQuestion());
		
		for(Answer a : question.getAnswers())
			System.out.println(a.getAnswer());
		
		session.close();
		factory.close();

	}

}
