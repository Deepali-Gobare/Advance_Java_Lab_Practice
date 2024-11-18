package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testSqlInjection {
         public static void main(String[] args) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
				Connection conn=DriverManager.getConnection(url, "dac22", "welcome");
				Statement st=conn.createStatement();
				String namefirst="rohit";
				String namelast="xyz' or '1'='1";
				String query="select * from student where namefirst='"+namefirst+"' and namelast='"+namelast+"'";
				System.out.println(query);
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
					System.out.println("namefirst : "+rs.getString(2));
					System.out.println("namelast: "+rs.getString(3));
					System.out.println("email : "+rs.getString(5));
					System.out.println("-----------");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
