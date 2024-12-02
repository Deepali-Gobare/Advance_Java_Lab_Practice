package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestSingleTable {
       public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Employee e=new Employee(20,"Rushi","12345","SWD","manager");
		Customer c=new Customer(13,"Shree","34261","pavai","Rushi");
		Session sess=factory.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(e);
		sess.save(c);
		tr.commit();
		sess.close();
		factory.close();
	}
}
