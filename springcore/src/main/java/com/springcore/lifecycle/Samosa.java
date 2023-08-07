package com.springcore.lifecycle;

public class Samosa {
	
	// Implementing LifeCycle methods of spring bean using XML
	
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting price");
		this.price = price;
	}

	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	
	// init and destroy method names can be anything, but the signature shouldn't supposed to change
	
	public void init() {
		System.out.println("Inside init method");
	}
	
	public void destroy() {
		System.out.println("Inside destory method");
	}

}
