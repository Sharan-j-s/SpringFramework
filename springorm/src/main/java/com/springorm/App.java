package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context  = new ClassPathXmlApplicationContext("config.xml");       
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);       
//       Student student = new Student(2324,"Durgesh Tiwari","Lucknow");       
//       int r = studentDao.insert(student);
//       System.out.println("done "+r);
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Boolean go = true;
       
       while(go) {
    	   System.out.println("******** Welcome to spring orm project ********");
           System.out.println("PRESS 1 for add new student");
           System.out.println("PRESS 2 for display all students");
           System.out.println("PRESS 3 for get details on single student");
           System.out.println("PRESS 4 for delete students");
           System.out.println("PRESS 5 for update student");
           System.out.println("PRESS 6 for exit");
           
           try {
        	   
        	  int input = Integer.parseInt(br.readLine());
        	  
        	switch (input) {
			case 1:
				//add a new student
				//taking inputs from user
				System.out.println("Enter user id : ");
				int uId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter user name : ");
				String uName = br.readLine();
				
				System.out.println("Enter user city : ");
				String uCity = br.readLine();
				
				//creating student object and setting values
				Student student = new Student();
				student.setStudentId(uId);
				student.setStudentName(uName);
				student.setStudentCity(uCity);
				
				//saving student object to db by calling insert() of student dao
				int r = studentDao.insert(student);
				System.out.println(r +" student added");
				System.out.println("*********************");
				System.out.println();
				
				break;
			case 2:
				//display all students
				System.out.println("*********************");
				List<Student> allStudents = studentDao.getAllStudents();
				for(Student st : allStudents) {
					System.out.println("Id : "+st.getStudentId());
					System.out.println("Name : "+st.getStudentName());
					System.out.println("City : "+st.getStudentCity());
					System.out.println("------------------------");
				}
				System.out.println("*********************");
				
				break;
			case 3:
				//get single student data
				System.out.println("Enter user id : ");
				int userId = Integer.parseInt(br.readLine());
				Student student2 = studentDao.getStudent(userId);
				System.out.println("Id : "+student2.getStudentId());
				System.out.println("Name : "+student2.getStudentName());
				System.out.println("City : "+student2.getStudentCity());
				System.out.println("------------------------");
				
				break;
			case 4:
				//delete student
				System.out.println("Enter user id : ");
				int id = Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);			
				System.out.println("Student deleted...");
				
				break;
			case 5:
				//update student
				break;
			case 6:
				//exit
				go = false;
				break;
        	}	
		} catch (Exception e) {
			System.out.println("Invalid Input Try with another one !!");
			System.out.println(e.getMessage());
		}
       }
       System.out.println("Thankyou for using my application");
       System.out.println("See you soon !!!");
    }
}

