package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.beans.Product;

public class ProductDaoImpl  implements ProductDao{
	
	static SessionFactory factory;
	static {
		factory=HibernateUtil.getConnection();
	}

	public boolean saveProduct(Product p) {
	      Session session=factory.openSession();
	      Transaction tr=session.beginTransaction();
	      session.save(p);
	      tr.commit();
	      session.close();
	      
		return true;
	}

	@Override
	public List<Product> displayAll() {
         Session session=factory.openSession();
         Transaction tr=session.beginTransaction();
         Query query=session.createQuery("From Product");
         List<Product> plist=query.getResultList();
         tr.commit();
         session.clear();
		return plist;
	}

	@Override
	public boolean removeById(int pid) {
	Session session=factory.openSession();
	Transaction tr=session.beginTransaction();
	Product p=session.get(Product.class,pid);
	boolean status;
	if(p!=null) {
		session.delete(p);
		status=true;
	}else {
		return false;
	}
	tr.commit();
	session.close();
	return status;
	}

	@Override
	public boolean modifyById(int pid, int qty, double pr) {
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		Product p=session.get(Product.class,pid);
		boolean status;
		if(p!=null) {
			p.setQty(qty);
			p.setPrice(pr);
			session.update(p);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public Product searchById(int pid) {
	Session session=factory.openSession();
	Transaction tr=session.beginTransaction();
	Product p=session.get(Product.class,pid);
	if(p!=null) {
		tr.commit();
		session.close();
		return p;
	}
	session.close();
    return null;
	}

	@Override
	public List<Product> arrengeByName() {
	  Session session=factory.openSession();
	  Transaction tr=session.beginTransaction();
	  Query query=session.createQuery("From Product p order by p.pname desc");
	  List<Product> plist=query.getResultList();
	  tr.commit();
	  session.close();
	  return plist;
		
	}

	@Override
	public void shutDown() {
		HibernateUtil.closeMySection();
		
	}

}
