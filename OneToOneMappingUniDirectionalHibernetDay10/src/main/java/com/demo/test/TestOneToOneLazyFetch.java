package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOneLazyFetch {

	public static void main(String[] args) {
	    SessionFactory sf= new Configuration().configure().buildSessionFactory();
	    Session sess=sf.openSession();
	    System.out.println("before");
//	    Faculty f=sess.get(Faculty.class, 1);
	    Course c=sess.get(Course.class, 1);
//	    Faculty f1=sess.load(Faculty.class, 1);
	    System.out.println("After");
	    System.out.println();
		System.out.println(c);
		System.out.println();
//		System.out.println(c);
		System.out.println();
//		System.out.println("with get"+f.getFname()+"-----" +f.getAddress());
	
//		System.out.println("with load"+f1.getFname()+"-----" +f1.getAddress());
		System.out.println("The data with get");
	
//		System.out.println(f.getC1());
	
//		System.out.println("the data with load");
//		System.out.println(f1);
//		System.out.println(f1.getC1());
//		tr.commit();
		sf.close();
	     
	    

	}

}
