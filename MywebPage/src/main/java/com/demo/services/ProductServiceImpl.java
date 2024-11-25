package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao pdao;
	

	public ProductServiceImpl(ProductDao pdao) {
		super();
		this.pdao = new ProductDaoImpl();
	}


	@Override
	public List<Product> getAllData() {
		// TODO Auto-generated method stub
		return pdao.getData();
	}

}
