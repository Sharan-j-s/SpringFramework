package com.framework.hibernate;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity - the hibernate will create db table on its own for this student class. 
//@Table(name = "mystudents") can be used to change table name, now the table name is mystudents.
//@Id represents the primarykey of the table
//@GeneratedValue - hibernate will automatically generate values for that using an internal sequence. Therefore we don't set it manually
//@Column - Can be used to specify column mappings. For example, to change the column name in associate table in database.
//@Transient - This tells hibernate not to save this field (the data member or class column).
//@Temporal - @Temporal over a date field tells hibernate the format in which the date needs to be saved.
//@Lob - tells hibernate that this is a large object, not a simple object.
//@OneToOne, @OneToMany, @ManyToOne, @JoinColumn etc.
//Check Address.java class, we've used many annotations there

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	private int id;
	
	private String name;
	
	private String city;
	
	private Certificate certi;
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
