package com.map;

import java.net.Socket;

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
		question.setAnswer(answer);

		// creating question
		Question question1 = new Question();
		question1.setQuestionId(242);
		question1.setQuestion("What is Collection Framework?");

		// creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API to work with objects in java");
		answer1.setQuestion(question1);
		question1.setAnswer(answer1);

		// session
		Session session = factory.openSession();
		Transaction txTransaction = session.beginTransaction();
		
		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);
		
		txTransaction.commit();
		
		
		//fetching...
		Question newQuestion = session.get(Question.class, 242);
		System.out.println(newQuestion.getQuestion());
		System.out.println(newQuestion.getAnswer().getAnswer());

		session.close();
		factory.close();

	}

}
