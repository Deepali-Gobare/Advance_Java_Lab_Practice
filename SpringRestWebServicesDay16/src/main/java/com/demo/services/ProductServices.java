package com.demo.services;

import java.util.List;

import com.demo.bean.Product;

public interface ProductServices {

	List<Product> getAllProducts();

	Product getById(int pid);


	boolean addNewProduct(Product p);

	boolean upadateProduct(Product p);

}
