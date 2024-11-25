package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addData();

	boolean pdel(int id);

	boolean pupdate(int id, int qty, double price);

	List<Product> findAll();

	Product findById(int id);

	List<Product> inSorted();

	void closeMyConnection();

}
