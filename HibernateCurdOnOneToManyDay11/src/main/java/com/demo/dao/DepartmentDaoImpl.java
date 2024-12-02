package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	static SessionFactory sf;
	   static {
		   sf=HibernateUtil.getMyConnection();
	   }

	public void saveDepartment(Department d) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(d);
		tr.commit();
		sess.close();
		
	}

}
