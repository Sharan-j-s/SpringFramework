package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean{
	
	// Implementing Bean Lifecycle using interfaces InitializingBean & DisposableBean
	
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Pepsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	public void afterPropertiesSet() throws Exception {
		// write implements InitializingBean for class, click on add unimplemented method - this method will be added
		// this method works like init() method, only the function name is changed.
		System.out.println("taking pepsi: init");		
	}

	public void destroy() throws Exception {
		// destroy method
		System.out.println("Going to put bottle back to shop: destroy");	
	}
	
	

}
