package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.services.ProductService;

public class TestJdbcTemplate {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc =new Scanner (System.in);
		ProductService ps=(ProductService)ctx.getBean("productServiceImpl");
		int choice=0;
		do {
			System.out.println("\n\n\n 1. add new product\n 2. delete product\n 3. modify product");
			System.out.println("4. display by id\n 5. display all\n 6. display by price\n7.exit\nchoice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				ps.addNewProduct();
				break;
			case 2:
				System.out.println("Enteer pid to delte product");
				int pid=sc.nextInt();
				boolean status=ps.deleteProduct(pid);
				if(status)
					System.out.println("Deleted Successfully");
				else {
					System.out.println("eror");
				}
				break;
			case 3:
				System.out.println("Enter Pid to update");
				pid= sc.nextInt();
				System.out.println("Enter New price");
				double price=sc.nextDouble();
				System.out.println("Enter new Qty");
				
				int qty=sc.nextInt();
				status=ps.updateById(pid,price,qty);
				if(status)
					System.out.println("updated Successfully");
				else {
					System.out.println("eror");
				}
				break;
			case 4:
				System.out.println("Enteer pid to display product");
				 pid=sc.nextInt();
				Product p=ps.displayProduct(pid);
				if(p!=null) {
					System.out.println(p);
					
				}else {
				   System.out.println("error");
				}
		         
		
				break;
			case 5:
					List<Product> plist1= ps.getAll();
					plist1.forEach(System.out::println);
				
				break;
			case 6:
				System.out.println("Enter Price to display product");
				price=sc.nextDouble();
				 p=ps.getPrice(price);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Price not found");
				}
				
				break;
			case 7:
				System.out.println("Thank you for visiting");
				sc.close();
				break;
			default:
				System.out.println("invalid choice");
				break;
			}
				
		}while(choice!=7);
	}
		
	}


