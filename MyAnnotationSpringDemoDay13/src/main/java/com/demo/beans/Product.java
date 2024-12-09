package com.demo.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@Value("12")
	private int pid;
	@Value("xxxx")
	private String pname;
	@Value("111")
	private int qty;
	@Autowired
	Catogary c;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
    
	@PostConstruct
	public void myinit() {
		System.out.println("Myinit");
	}
	@PreDestroy
	public void MyDestroy() {
		System.out.println("MyDestroy");
	}
	



	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", c=" + c + "]";
	}

	public Catogary getC() {
		return c;
	}

	public void setC(Catogary c) {
		this.c = c;
	}


	
	
	

}
