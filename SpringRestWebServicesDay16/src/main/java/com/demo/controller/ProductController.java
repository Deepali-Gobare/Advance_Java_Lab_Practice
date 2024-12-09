package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Product;
import com.demo.services.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServices ps;
	
	@GetMapping("/products")
	public ResponseEntity<List <Product>> getallProduct(){
	List<Product> plist=ps.getAllProducts();
	return  ResponseEntity.ok(plist );
}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getById(@PathVariable int pid){
		Product p=ps.getById(pid);
		if(p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(500).body(null);
	}
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addProduct(@RequestBody Product p){
		boolean status=ps.addNewProduct(p);
		if(status) {
			return ResponseEntity.ok("Data added successfully");
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		boolean status=ps.upadateProduct(p);
		if(status) {
			return ResponseEntity.ok("Data updated successfully");
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
