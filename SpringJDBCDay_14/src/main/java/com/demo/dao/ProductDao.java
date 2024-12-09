package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void saveProduct(Product p);

	boolean removeProduct(int pid);

	

	boolean modifyById(int pid, double price, int qty);

	Product showProd(int pid);

	List<Product> displayAll();

	Product showPrice(double price);

}
