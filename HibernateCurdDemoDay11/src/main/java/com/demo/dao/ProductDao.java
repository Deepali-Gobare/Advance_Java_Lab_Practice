package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean saveProduct(Product p);

	List<Product> displayAll();

	boolean removeById(int pid);

	boolean modifyById(int pid, int qty, double pr);

	Product searchById(int pid);

	List<Product> arrengeByName();

	void shutDown();
	

}
