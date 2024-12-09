package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class TestMyLocale {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. US english \n 2. UK english \n 3. Marathi \n 4. others \n 5.exit \n choices");
			System.out.println("Select language");
			MessageSource ms= (MessageSource)ctx.getBean(ResourceBundleMessageSource.class); 
			String m=null,w=null,d=null,c=null;
			Locale locale=null;
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				locale=Locale.US;
				System.out.println("country:"+locale.getCountry()+"language:"+locale.getLanguage());
				
				break;
			case 2:
				locale=Locale.UK;
				System.out.println("country:"+locale.getCountry()+"language:"+locale.getLanguage());
				break;
			case 3:
				locale=new Locale("my","marathi");
				System.out.println("country:"+locale.getCountry()+"language:"+locale.getLanguage());
				break;
			case 4:
				locale=new Locale("aa","test");
				System.out.println("country:"+locale.getCountry()+"language:"+locale.getLanguage());
				break;
			case 5:
				System.out.println("Thanks Visit again....");
				break;
			default:
			break;
			}
			
			m=ms.getMessage("msg.pay",new Object[] {"hello","hy"},locale);
			w=ms.getMessage("msg.welcome",new Object[] {"Deepali"},locale);
			d=ms.getMessage("msg.data",null,locale);
			c=ms.getMessage("msg.currency",null,locale);
			System.out.println("pay "+m);
			System.out.println("pay "+w);
			System.out.println("pay "+d);
			System.out.println("pay "+c);
		}
		while(choice!=5);
		
		
	}

}
