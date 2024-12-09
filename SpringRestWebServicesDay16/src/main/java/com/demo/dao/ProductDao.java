package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;

public interface ProductDao {

	List<Product> findAll();



	Product findById(int pid);






	boolean addproduct(Product p);



	boolean modifyproduct(Product p);

}
