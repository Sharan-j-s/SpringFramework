package com.framework.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
//        Configuration cfg = new Configuration(); //same as above
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student student = new Student();
        student.setId(103);
        student.setName("Varun");
        student.setCity("Kolkata");
        System.out.println(student);
        
        //creating object of address class
        Address address = new Address();
        address.setStreet("street2");
        address.setCity("Lucknow");
        address.setOpen(true);
        address.setAddeDate(new Date());
        address.setX(22.234);
        
        //reading image
        FileInputStream fileInputStream = new FileInputStream("src/main/java/Gui.JPG");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        address.setImage(data);
        
        //saving to db
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(address);
        tx.commit();        
        session.close();
        
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
			
    }
}
