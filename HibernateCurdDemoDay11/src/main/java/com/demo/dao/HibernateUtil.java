package com.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static SessionFactory factory=null;
	public static SessionFactory getConnection() {
		if(factory==null){
		    factory=new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	public static void closeMySection() {
		factory.close();
	}

}

