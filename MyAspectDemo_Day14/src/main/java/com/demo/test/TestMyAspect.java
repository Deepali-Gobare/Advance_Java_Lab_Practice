package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;

public class TestMyAspect {

	public static void main(String[] args) {
ApplicationContext ctx=new ClassPathXmlApplicationContext("springcomfig.xml");
MyClass ob=(MyClass)ctx.getBean("myClass");
	ob.m1();
	ob.m2();
	ob.getX();
	ob.m3(2);

	}

}
