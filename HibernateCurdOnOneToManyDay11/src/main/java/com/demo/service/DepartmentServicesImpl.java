package com.demo.service;

import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;

public class DepartmentServicesImpl implements DepartmentService {
	   DepartmentDao ddao;

	


	public DepartmentServicesImpl() {
		super();
		this.ddao = new DepartmentDaoImpl();
	}




	public void addnewDept() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr deptid");
		int deptid=sc.nextInt();
		System.out.println("enetr dname");
		String dnm=sc.next();
		System.out.println("enetr location");
		String dloc=sc.next();
		Department d=new Department(deptid,dnm,dloc,null);
		ddao.saveDepartment(d);
		
	}

}
