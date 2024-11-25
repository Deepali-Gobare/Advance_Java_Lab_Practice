package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class loginDaoImpl implements loginDao {
      private static Connection conn;
      private static PreparedStatement selUser;
      static {
    	  try {
    		  conn=DBUTIL.getConnection();
    		  selUser=conn.prepareStatement("select uname, passwd,role from users where uname=? and passwd=?");
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
      }
	@Override
	public MyUser authenticateuser(String uname, String pass) {
		try {
			selUser.setString(1,uname);
			selUser.setString(2, pass);
			ResultSet rs=selUser.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
