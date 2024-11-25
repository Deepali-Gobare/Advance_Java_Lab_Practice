package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testconnection {

	public static void main(String[] args) {
		try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
		Connection conn= DriverManager.getConnection(url,"dac22","welcome");
		if(conn!=null) {
			System.out.println("Connection done");
		}else {
			System.out.println("Error In conection");
		}
	 conn.close();	
	}catch ( SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}{
		
	}
	}
}
