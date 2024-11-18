package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class testCallableStatement {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"dac22","welcome");
			java.sql.CallableStatement cst= conn.prepareCall("call getcnt(?,?)");
			cst.setInt(1,12);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.execute();
//			ResultSet rs=cst.getResultSet();
//			if(rs.next()) {
//				String result=rs.getString("R2");
//				System.out.println(result);
//			}
			int cnt=cst.getInt(2);
			System.out.println("Count : "+cnt);
		
			conn.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
