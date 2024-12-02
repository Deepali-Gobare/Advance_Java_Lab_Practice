package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestRetriveData {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session sess=factory.openSession();
		Transaction tr=sess.beginTransaction();
		Employee e=sess.get(Employee.class, 20);
		System.out.println(e);
		Customer c=sess.get(Customer.class, 13);
		System.out.println(c);
		tr.commit();
		sess.close();
		factory.close();
	}

}
