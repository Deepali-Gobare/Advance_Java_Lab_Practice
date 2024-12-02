package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

//import java.lang.module.Configuration;



public class TestStudentProductAnnotation {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session =sf.openSession();
		Transaction tr= session.beginTransaction();
		Student s= new Student("Dnyanes","9420",95);
		Student s1=new Student("Anil","4444",97);
		Student s2=new Student("Vikam","4444",97);
		Product p=new Product(1001,"Table",2,4000);
		Product p1=new Product(1002,"Table",2,4000);
//		session.save(s);
//		session.save(s1);
//		session.save(s2);
//		session.save(p);
//		session.save(p1);
//		tr.commit();
//		session.close();
//		sf.close();
		Student ss1=session.get(Student.class,3);
		System.out.println(ss1);
		
		
		
	}
}
