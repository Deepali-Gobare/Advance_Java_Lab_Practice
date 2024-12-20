package com.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
		ProductDao pdao;
		
	
	public void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter pname");
		String pname=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		double price=sc.nextDouble();
		System.out.println("enter expiry date(dd/MM/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("enter cid");
		int cid=sc.nextInt();
		Product p=new Product(pid,pname,qty,price,ldt,cid);
		pdao.saveProduct(p);
		
	}


	public boolean deleteProduct(int pid) {
		
		return pdao.removeProduct(pid);
		
		
	}


	public boolean updateById(int pid, double price, int qty) {
		
		return pdao.modifyById(pid,price,qty);
	}


	@Override
	public Product displayProduct(int pid) {
		
		return pdao.showProd(pid);
	}


	@Override
	public List<Product> getAll() {
		
		return pdao.displayAll();
	}


	@Override
	public Product getPrice(double price) {
		
		return pdao.showPrice(price);
	}

}
