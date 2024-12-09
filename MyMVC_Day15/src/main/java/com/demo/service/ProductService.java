package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.beans.Product;
@Service
public interface ProductService {

	List<Product> getAllpoduct();

	

	boolean addnewProduct(Product p);



	boolean deleteByid(int pid);



	Product getById(int pid);



	boolean updateProduct(Product p);

}
