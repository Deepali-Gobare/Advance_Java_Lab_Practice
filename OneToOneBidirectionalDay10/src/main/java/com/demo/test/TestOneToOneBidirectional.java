package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;



public class TestOneToOneBidirectional {
          public static void main(String[] args) {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
//			Course c=new Course();
//			c.setCname("java");
//			c.setDuration(34);
//			Faculty f1=new Faculty("tttt","ffff",c);
//		    c.setF(f1);
//		    Session sess=sf.openSession();
//		    Transaction tr=sess.beginTransaction();
//		    sess.save(c);
//		    sess.save(f1);
//		    tr.commit();
//		    sess.close();
		    

			  Session sess1=sf.openSession(); 
			  Transaction tr1=sess1.beginTransaction();
			  Course c=sess1.get(Course.class, 1); 
			  if(c!=null) { 
				  sess1.delete(c); 
				 }
			  tr1.commit(); 
			  sess1.close();
			 
			sf.close();
		}
}
