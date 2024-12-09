package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;

@Service

public class ProudctServiceImpl implements ProductServices {
@Autowired
ProductDao pdao;
	public List<Product> getAllProducts() {
		
		return pdao.findAll();
	}
	@Override
	public Product getById(int pid) {
		
		return pdao.findById(pid);
	}
	@Override
	public boolean addNewProduct(Product p) {
		
		return pdao.addproduct(p);
	}
	@Override
	public boolean upadateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.modifyproduct(p);
	}

}
