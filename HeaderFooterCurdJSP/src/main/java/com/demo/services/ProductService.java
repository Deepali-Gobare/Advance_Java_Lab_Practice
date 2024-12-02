package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllData();

	boolean insertProduct(Product p);
	
	boolean deletById(int pid);

	Product getById(int pid);

	boolean updateProduct(Product p);


	



}
