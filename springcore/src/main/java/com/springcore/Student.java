package com.springcore;

public class Student {
	
	private int studentId;
	private String studentName;
	private String studentAddress;
	
	public Student(int studentId, String studentName, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	
	public Student() {
		super();
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
	//	System.out.println("Setting studentID");
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
	//	System.out.println("Setting studentName");
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
	//	System.out.println("Setting studentAddress");
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}
	
	

}
