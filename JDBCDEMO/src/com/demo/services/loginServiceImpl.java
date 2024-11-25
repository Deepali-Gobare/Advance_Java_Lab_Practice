package com.demo.services;
	
import com.demo.beans.MyUser;
import com.demo.dao.loginDao;
import com.demo.dao.loginDaoImpl;

public class loginServiceImpl implements loginServices {
	
	private  loginDao ldao;
	
	

	public loginServiceImpl() {
		super();
		this.ldao = new loginDaoImpl();
	}



	public MyUser validateUser(String uname, String pass) {
	
		return ldao.authenticateuser(uname,pass);
	}

}
