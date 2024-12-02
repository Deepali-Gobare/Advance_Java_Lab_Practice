package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServicesImpl;

public class TestCurdDemo {
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	ProductService ps=new ProductServicesImpl();
	int choice=0;
	do {
		System.out.println("1.Add new Product \n2.Display ALL \n3.delete by Id \n4.update by id");
		System.out.println("5.display by id \n6.sort by name \n7.exist \n choice:");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			boolean status =ps.addNewProduct();
			if(status) {
				System.out.println("product added successFully");
			}
			else {
				System.out.println("error occured");
			}
			break;
		case 2:
			List<Product> plist=ps.FindAll();
			plist.forEach(System.out::println);
			break;
		case 3:
			System.out.println("Enter id");
			int pid=sc.nextInt();
			status=ps.deleteById(pid);
			if(status) {
				System.out.println("product deleted successFully");
			}
			else {
				System.out.println("error occured");
			}
			
			break;
		case 4:
			System.out.println("enter id");
			 pid=sc.nextInt();
			 System.out.println("enter new qty");
			 int qty=sc.nextInt();
			 System.out.println("enter price");
			 double pr=sc.nextDouble();
			status=ps.updateById(pid,qty,pr);
			if(status) {
				System.out.println("product updated successfully");
				
			}else {
				System.out.println("error occured");
			}
			break;
		case 5:
			System.out.println("enter id");
			 pid=sc.nextInt();
			 Product p=ps.findById(pid);
			 if(p!=null) {
				 System.out.println(p);
			 }else {
				 System.out.println("product not found"+pid);
			 }
			break;
		case 6:
			plist=ps.sortByName();
			if(plist!=null) {
		
				plist.forEach(System.out::println);
			}
			else {
				System.out.println("Table is empty");
			}
			break;
		case 7:
			System.out.println("Thank you for visiting....");
			sc.close();
			 ps.closeSession();
			break;
		default:
			System.out.println("Choice not found");
			break;

		}
	}while(choice!=7);

}

}
