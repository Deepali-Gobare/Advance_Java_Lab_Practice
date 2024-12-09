package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;

@Service
public interface LoginService {

	MyUser findUser(String unm, String passwd);

}
