package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Course c1=new Course("java",90);
		Faculty f1=new Faculty("xxx","yyy",c1);
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(c1);
		session.save(f1);
		tr.commit();
		session.close();
//		Session sess=sf.openSession();
//        Faculty f2=sess.get(Faculty.class,1);
//        System.out.println(f2);
//        Course c2=sess.get(Course.class, 1);
//        System.out.println(c2);
        sf.close();
		
	}

}
