package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;
import com.demo.beans.Product;

public class TestHelloworld {

	public static void main(String[] args) {
	      ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	      System.out.println("before");
	      HelloWorld hw=(HelloWorld)ctx.getBean("hwbean");
	      System.out.println("After");
	      hw.sayHello();
	      Product p=(Product)ctx.getBean("p1");
	      System.out.println(p);
	      Product p1=(Product)ctx.getBean("p2");
	      System.out.println(p1);
	      
	}

}
