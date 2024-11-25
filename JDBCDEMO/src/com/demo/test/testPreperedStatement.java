package com.demo.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class testPreperedStatement {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
			conn=DriverManager.getConnection(url,"dac22","welcome");
			PreparedStatement pst=conn.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt(1));
				System.out.println("NameFirst :"+rs.getString(2));
				System.out.println("NameLast :"+rs.getString(3));
				System.out.println("Date :"+rs.getDate(4));
				System.out.println("Email :"+rs.getString(5));
				System.out.println("--------------------");
			}
			int id=31;
			String namefirst="Rohit";
			String namelast="sate";
			LocalDate DOB=LocalDate.of(2024,02,02);
			java.sql.Date sdt=Date.valueOf(DOB);
			String emailID="hfjshk";
		    PreparedStatement pst1=conn.prepareStatement("insert into student values(?,?,?,?,?)");
		    System.out.println("36 line");
			pst1.setInt(1, id);
			pst1.setString(2, namefirst);
			pst1.setString(3, namelast);
			pst1.setDate(4, sdt);
			pst1.setString(5, emailID);
			System.out.println("42 line");
			int n=pst1.executeUpdate();
				
			if(n>0)
				System.out.println("Insertion done");
			else
				System.out.println("Error");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}{
			
		}
	}
}
