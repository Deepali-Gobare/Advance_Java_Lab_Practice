package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/security")
public class LoginController {
	@Autowired
	LoginService ls;
	
	@GetMapping("/login")
	public String showlogin() {
		return "loginpage";
	}
	
	@PostMapping("/validate")
	public ModelAndView authecateuser(@RequestParam("uname") String unm,@RequestParam String passwd,HttpSession session) {
		MyUser user=ls.findUser(unm,passwd);
		if(user!=null) {
			session.setAttribute("user",user);
			return new ModelAndView("redirect:/product/getproduct");
//			
		}else {
//			String msg1="invalid user";
			return new ModelAndView("loginpage","msg","Wrong Credantials Entered");
		}
		
	}

}
