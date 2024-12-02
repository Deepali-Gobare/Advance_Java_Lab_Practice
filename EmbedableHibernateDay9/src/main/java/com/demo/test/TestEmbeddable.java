package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.Student;



public class TestEmbeddable {
	public static void main(String[] args) {
	     SessionFactory sf=new Configuration().configure().buildSessionFactory();
	     Session session=sf.openSession();
	     Transaction tr=session.beginTransaction();
	     Address adr=new Address(101,"MH","latur","41312");
	     
	     Student s=new Student(1,"deepali",123.0f,adr);
	     session.save(s);
	     tr.commit();
	     session.close();
	     sf.close();
	}

}
