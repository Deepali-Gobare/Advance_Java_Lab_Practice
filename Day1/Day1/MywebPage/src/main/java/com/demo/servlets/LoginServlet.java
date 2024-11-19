package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
    	res.setContentType("text/Html");
    	PrintWriter out=res.getWriter();
    	String uname=req.getParameter("uname");
    	String pass=req.getParameter("pass");
    	if(uname.equals("admin") && pass.equals("admin")) {
    		out.println("<h1>Login successfully</h1>");
    	}else {
    		out.println("<h1>Login unsuccessfully</h1>");
    	}
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
}
