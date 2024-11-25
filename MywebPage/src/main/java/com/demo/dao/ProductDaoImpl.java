package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.DBUtil;
import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn;
	static PreparedStatement adddata;
	
	static {
		conn=DBUtil.getMyConnection();
		try {
			adddata=conn.prepareStatement("select * from product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getData() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=adddata.executeQuery();
			while(rs.next()) {
		        plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));		
			}
			if(plist.size()>0) {
				return plist;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
