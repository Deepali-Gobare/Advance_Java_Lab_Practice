package com.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

 
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService ps;

	@GetMapping("/getproduct")
	public ModelAndView getAllproduct() {
		List<Product> plist=ps.getAllpoduct();
//		plist.forEach(System.out::println);
		return new ModelAndView("showproduct","plist",plist);
	}
	
	@GetMapping("/addnewproduct")
	public String displayForm(Model m) {
		m.addAttribute("u1",new Product());
		return "insertproduct";
	}
	
	@PostMapping("insertproduct")
	public ModelAndView insertProduct(@ModelAttribute Product p) {
		boolean status=ps.addnewProduct(p);
		
//		System.out.println(p);
		return new ModelAndView("redirect:/product/getproduct");
	}
	
	
	@GetMapping("deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		boolean status=ps.deleteByid(pid);
		return new ModelAndView("redirect:/product/getproduct");
		
	
}
	
	@GetMapping("editproduct/{pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p=ps.getById(pid);
		if(p!=null)
		   return new ModelAndView("editproduct","prod",p);
		else {
			return new ModelAndView("redirect:/product/getproduct");
		}
	}
	@PostMapping("/updateProduct")
	
	public ModelAndView updateProduct(@RequestParam int pid,@RequestParam String  pname,@RequestParam int qty,@RequestParam double price,@RequestParam String ldt,@RequestParam int cid) {
		LocalDate ldate=LocalDate.parse(ldt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p=new Product(pid,pname,qty,price,ldate,cid);
		boolean status=ps.updateProduct(p);
		return new ModelAndView("redirect:/product/getproduct");
	}
}