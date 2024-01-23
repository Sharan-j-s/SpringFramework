package com.spring.jdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class App 
{
    public static void main( String[] args )
    {
       // spring jdbc => JdbcTemplate
    	
       ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
       
       /* If we don't want to use xml based config, then we can use this annotation based using this.
       ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class); */
       
       //JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
       
       /*
       //insert query
       String query = "insert into student(id,name,city) values(?,?,?)";
       
       //fire query
       int result = template.update(query,523,"Shravan Kumar","Delhi");
       System.out.println("number of record insert..." +result);
       */
       
       // The above code is not a proper way of doing things, So in order to do it properly we are creating studentdao interface and everything
       
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
   // Insert Operation
//        Student student = new Student();
//        student.setId(741);
//        student.setName("Sharan");
//        student.setCity("Shimoga");
//        
//        int result = studentDao.insert(student);
//        
//        System.out.println("student added = " +result); 
        
    /*  Update Operation
     	Student student2 = new Student();
        student2.setId(666);
        student2.setName("Raj Kumar");
        student2.setCity("Lucknow");
        
        int result2 = studentDao.change(student2);
        
        System.out.println("student updated = "+result2); */
        
    /*  Delete Operation   
        int result3 = studentDao.delete(523);
        System.out.println("student deleted = "+result3); */
        
       //selecting single student
//       Student student = studentDao.getStudent(456);
//       System.out.println(student);
       
       //selecting multiple students
       List<Student> students = studentDao.getAllStudents();
       for(Student s : students)
    	   System.out.println(s);
        
        
       
       
       
    }
}
