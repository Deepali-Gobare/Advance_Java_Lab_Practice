package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao pdao;
	

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}


	@Override
	public List<Product> getAllData() {
		// TODO Auto-generated method stub
		return pdao.getData();
	}

	public boolean insertProduct(Product p) {
		return pdao.saveProduct(p);
	}
	
	public boolean deletById(int pid) {
		return pdao.removeById(pid);
	}


	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.findById(pid);
	}


	@Override
	public boolean updateProduct(Product p) {
		
		return pdao.modifyProd(p);
	}

}
