package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.bean.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Product> findAll() {
		return jdbcTemplate.query("select * from product" , (rs,rownum)->{
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setQty(rs.getInt(3));
			 p.setPrice(rs.getDouble(4));
		

			 p.setCid(rs.getInt(6));
			 return p;
		});
	
	}
	public Product findById(int pid) {
		try {
		return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},(rs,rownum)->{
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setQty(rs.getInt(3));
			 p.setPrice(rs.getDouble(4));
			// p.setLdt(rs.getDate(5).toLocalDate());
			 p.setCid(rs.getInt(6));
			 return p;
				});
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
//	@Override
	public boolean addproduct(Product p) {
		
		int n=jdbcTemplate.update("insert into product (pid,pname,qty,price,cid)values(?,?,?,?,?)",
				new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getCid()});
		return n>0;
	}
	@Override
	public boolean modifyproduct(Product p) {
		int n=jdbcTemplate.update("update product set pname=?,qty=?,price=?,cid=? where pid=?",
				new Object[] {p.getPname(),p.getQty(),p.getPrice(),p.getCid(),p.getPid()});
		return n>0;
	}

}
