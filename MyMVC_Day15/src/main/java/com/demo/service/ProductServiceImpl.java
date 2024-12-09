package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao pdao;
	
	
	public List<Product> getAllpoduct() {
		
		return pdao.findAllProduct();
	}


		
	


	public boolean addnewProduct(Product p) {
		
		return pdao.insertProduct(p);
	}






	@Override
	public boolean deleteByid(int pid) {
		
		return pdao.removeByid(pid);
	}






	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.findByid(pid);
	}






	@Override
	public boolean updateProduct(Product p) {
		
		return pdao.updatepoduct(p);
	}

}
