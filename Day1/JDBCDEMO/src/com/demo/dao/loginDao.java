package com.demo.dao;

import com.demo.beans.MyUser;

public interface loginDao  {

	MyUser authenticateuser(String uname, String pass);

}
