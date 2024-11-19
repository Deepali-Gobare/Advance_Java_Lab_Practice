package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;
import com.demo.services.loginServiceImpl;
import com.demo.services.loginServices;

public class testCRUDJDBCDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter UserName");
		String uname =sc.next();
		System.out.println("Enter PassWord");
		String pass =sc.next();
		loginServices ls= new loginServiceImpl();
		MyUser user = ls.validateUser(uname, pass);
		ProductService ps= new ProductServiceImpl();
		int choice=0;
		if(user!=null && user.getRole().equals("admin")) {
			do {
			System.out.println("\n1. Add new product\n2. Delete Product\n3. update product\n4.Display all");
			System.out.println("5. Find By ID\n6. display in sorted order by name\n7.exit\n choice:");
			choice=sc.nextInt();
			switch (choice) {
			case 1->{
				boolean status=ps.addData();
				if(status) {
					System.out.println("The data is inserted");
				}else {
					System.out.println("error occered");
				}
			}
			case 2 ->{
				System.out.println("Enter pid to delete");
				int id=sc.nextInt();
				boolean status=ps.pdel(id);
				if(status) {
					System.out.println("The data is deleted");
				}else {
					System.out.println("error occered");
				}
				
				
			}
			case 3 ->{
				System.out.println("Enter Pid to upadte");
				int id=sc.nextInt();
				System.out.println("Enter new qty to upadte");
				int qty=sc.nextInt();
				System.out.println("Enter New Price");
				double price=sc.nextDouble();
				boolean status=ps.pupdate(id,qty,price);
				if(status) {
					System.out.println("The data is updated");
				}else {
					System.out.println("error occered");
				}
			}
			case 4->{
				List<Product> plist=ps.findAll();
				if(plist!=null) {
					plist.stream().forEach(System.out::println);
				}else {
					System.out.println("Not found");
				}
			}
			case 5->{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				Product p=ps.findById(id);
				if(p!=null){
					System.out.println(p);
				}else {
					System.out.println("Not found");
				}
			}
			case 6 ->{
				List<Product> plist=ps.inSorted();
				if(plist!=null) {
					plist.stream().forEach(System.out::println);
				}else {
					System.out.println("Error");
				}
				
			}
			case 7 ->{
				System.out.println("Thank You");
				sc.close();
				ps.closeMyConnection();
			}
			default ->{
				System.out.println("Choice not found");
			}
			
			}
				
		}while(choice<8);
		}
		
	}

}
