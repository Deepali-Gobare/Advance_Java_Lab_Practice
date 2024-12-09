package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Catogary;
import com.demo.beans.Product;

public class TestAnnotation {

	public static void main(String[] args) {
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	    Product p=(Product)ctx.getBean("product");
	    Catogary c=(Catogary)ctx.getBean("catogary");
	    System.out.println(p);
		System.out.println(c);
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
