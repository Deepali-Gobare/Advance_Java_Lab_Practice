package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveProduct(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?,?,?)", new Object[]{
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()
		});
		
	}

	public boolean removeProduct(int pid) {
		int n=jdbcTemplate.update("delete from product where pid=?",pid);
		if(n>0) {
			return true;
		}
		return false;
	}

	public boolean modifyById(int pid, double price, int qty) {
		int n=jdbcTemplate.update("UPDATE product SET price = ?, qty = ? WHERE pid = ?",price,qty,pid);
		if(n>0) {
		return true;
		}
		return false;
	}

	@Override
	public Product showProd(int pid) {
		Product p=(Product) jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid} , BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public List<Product> displayAll() {
		List<Product> plist1= jdbcTemplate.query("select * from product",(rs,numrows)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
//			System.out.println("..........");
			
			return p;
			
		});
		return plist1;
	}

	@Override
	public Product showPrice(double price) {
		Product p=(Product) jdbcTemplate.queryForObject("select * from product where price=?", new Object[] {price}, BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

}
