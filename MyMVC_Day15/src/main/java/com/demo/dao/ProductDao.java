package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProduct();


	boolean insertProduct(Product p);


	boolean removeByid(int pid);


	Product findByid(int pid);


	boolean updatepoduct(Product p);

}
