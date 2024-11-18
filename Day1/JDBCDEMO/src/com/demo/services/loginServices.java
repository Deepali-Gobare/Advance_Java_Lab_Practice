package com.demo.services;

import com.demo.beans.MyUser;

public interface loginServices {

	MyUser validateUser(String uname, String pass);

}
