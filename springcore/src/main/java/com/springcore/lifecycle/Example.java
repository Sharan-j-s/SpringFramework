package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	
	// Implementing Bean LifeCycle using Annotations @PostConstruct @PreDestroy
	
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	
	// we need to add javax.annotation-api dependency to use these annotations
	// also in config.xml file we need to use <context:annotation-config /> to enable all annotation
	
	@PostConstruct
	public void start() {
		System.out.println("starting method");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("ending method");
	}
}
