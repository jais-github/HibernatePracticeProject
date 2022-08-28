package com.practice.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
 * This main class has been made to demonstrate the working and usage of
 * Embeddable Annotation 
 */
public class EmDemo {
	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        Student student1 = new Student();
	        student1.setId(123);
	        student1.setName("Ayush Jaiswal");
	        student1.setCity("Bangalore");
	        
	        Certificate certificate = new Certificate();
	        certificate.setCourse("Android");
	        certificate.setDuration("2 months");
	        student1.setCerti(certificate);
	        
	        Student student2 = new Student();
	        student2.setId(456);
	        student2.setName("Kingson rana");
	        student2.setCity("Bangalore");
	        
	        Certificate certificate1 = new Certificate();
	        certificate1.setCourse("SpringBoot");
	        certificate1.setDuration("1.5 months");
	        student2.setCerti(certificate); 
	        
	        Session s= factory.openSession();
	        Transaction tx = s.beginTransaction();
	        
	        //object save
	        s.save(student1);
	        s.save(student2);
	        
	        tx.commit();
	        s.close();
	        
	        factory.close();
	}
}
