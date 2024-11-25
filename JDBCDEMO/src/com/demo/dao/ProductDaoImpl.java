package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements productDao {
	
	static Connection con;
	static PreparedStatement pstat,pdel,pupdate,pselect,pfind,porder;
	static {
		try {
			con=DBUTIL.getConnection();
			pstat=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			pdel=con.prepareStatement("delete from product where pid=?");
			pupdate=con.prepareStatement("update product set qty=?, price=? where pid=?");
			pselect=con.prepareStatement("select * from product");
			pfind=con.prepareStatement("select * from product where pid=?");
			porder=con.prepareStatement("select * from product order by pname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean save(Product p) {
		try {
	   pstat.setInt(1, p.getPid());
	   pstat.setString(2, p.getPname());
	   pstat.setInt(3, p.getQty());
	   pstat.setDouble(4, p.getPrice());
	   pstat.setDate(5, Date.valueOf(p.getExpdate()));
	   pstat.setInt(6, p.getCid());
	   int res=pstat.executeUpdate();
	   if(res>0) {
		   return true;
	   }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			pdel.setInt(1,id);
		int n=pdel.executeUpdate();
		if(n>0) {
			return true;
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateById(int id, int qty, double price) {
		try {
			pupdate.setInt(3, id);
			pupdate.setInt(1, qty);
			pupdate.setDouble(2, price);
			int n=pupdate.executeUpdate();
			if(n>0) {
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> displayAll() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=pselect.executeQuery();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
				plist.add(p);
			}
			if(plist.size()>0) {
				return plist;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product searchById(int id) {
		try {
		pfind.setInt(1, id);
		ResultSet rs=pfind.executeQuery();
		if(rs.next()) {
		 Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
		 return p;
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> sortedOrder() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=porder.executeQuery();
			while(rs.next()) {
				 Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
				 plist.add(p);
			}if(plist.size()>0) {
				return plist;
			}
			}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void closeConnection() {
		DBUTIL.closeMyConnection();
		
	}
	

}
