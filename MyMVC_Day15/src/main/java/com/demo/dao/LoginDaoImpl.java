package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//@Override
	public MyUser validatUser(String unm, String passwd) {
		try {
			
		
		return jdbcTemplate.queryForObject("select uname,passwd,role from users where uname=? and passwd=?", 
				new Object[] {unm,passwd},BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println("User not found");
		}
		
		return null;
	}

}
