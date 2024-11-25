package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class testCreateStatement {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"dac22","welcome");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt(1));
				System.out.println("NameFirst :"+rs.getString(2));
				System.out.println("NameLast :"+rs.getString(3));
				System.out.println("Date :"+rs.getDate(4));
				System.out.println("Email :"+rs.getString(5));
				System.out.println("--------------------");
			}
			int id=30;
			String namefirst="Varsha";
			String namelast="patil";
			LocalDate DOB=LocalDate.of(2025,02,02);
			String emailID="shdkuhsfuighe";
			String query="insert into student values("+id+",'"+namefirst+"','"+namelast+"','"+DOB+"','"+emailID+"')";
			System.out.println(query);
			int n= st.executeUpdate(query);
			if(n>0)
				System.out.println("Insertion done");
			else
				System.out.println("Error");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
