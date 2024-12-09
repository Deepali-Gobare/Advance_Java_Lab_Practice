package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	boolean deleteProduct(int pid);

	boolean updateById(int pid, double price, int qty);

	Product displayProduct(int pid);

	List<Product> getAll();

	Product getPrice(double price);

}
