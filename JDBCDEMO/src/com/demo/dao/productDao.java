package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface productDao {

	boolean save(Product p);

	boolean deleteById(int id);

	boolean updateById(int id, int qty, double price);

	List<Product> displayAll();

	Product searchById(int id);

	List<Product> sortedOrder();

	void closeConnection();

}
