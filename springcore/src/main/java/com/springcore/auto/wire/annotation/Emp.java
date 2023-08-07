package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
	
	// we can use @Autowired annotation on setter, properties, constructor
	// with qualifier annotation we can choose which bean to inject for the property, using bean name
	
	@Autowired
	@Qualifier("temp2")
	private Address address;

	public Address getAddress() {
		return address;
	}
	
	//@Autowired
	public void setAddress(Address address) {
		System.out.println("setter");
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@Autowired
	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("constructor");
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	
	

}
