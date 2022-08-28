package com.practice.HibernatePractice;



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
        System.out.println( "Project is Working Properly..." );
       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //can also be created as
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
       // System.out.println(factory);
        
     //   System.out.println(factory.isClosed());
        
        //create student
        
       Student st = new Student();
        st.setId(102);
        st.setName("kingson");
        st.setCity("Bangalore");
        System.out.println(st);
        
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Bangalore");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
       
     /*
        //creating object of students class
        FileInputStream fis = new FileInputStream("src/main/java/acharyalogo(1).png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
     */   
        Session session =factory.openSession();
        
        //get- student :101
        
       // Student student = (Student) session.get(Student.class, 102);
       // System.out.println(student);
        
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
      //  System.out.println("Done");
        
        tx.commit();
       // session.getTransaction().commit();
        
        
        session.close();
    }
}
