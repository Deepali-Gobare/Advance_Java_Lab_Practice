package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServicesImpl implements ProductService{
	ProductDao pdao;
	

	public ProductServicesImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}


	public boolean addNewProduct() {
		Scanner sc=new Scanner(System.in);

		System.out.println("Enetr pname");
		String pname=sc.next();
		System.out.println("Enetr Qty");
		int qty=sc.nextInt();
		System.out.println("Enetr price");
		double price=sc.nextDouble();
		Product p=new Product(pname,qty,price);
		return pdao.saveProduct(p);
	}


	@Override
	public List<Product> FindAll() {
		
		return pdao.displayAll();
	}


	@Override
	public boolean deleteById(int pid) {
	
		return pdao.removeById(pid);
	}


	@Override
	public boolean updateById(int pid, int qty, double pr) {
		// TODO Auto-generated method stub
		return pdao.modifyById(pid,qty,pr);
	}


	@Override
	public Product findById(int pid) {
		
		return pdao.searchById(pid);
	}


	@Override
	public List<Product> sortByName() {
		
		return pdao.arrengeByName();
	}


	@Override
	public void closeSession() {
		pdao.shutDown();
		
	}

}
