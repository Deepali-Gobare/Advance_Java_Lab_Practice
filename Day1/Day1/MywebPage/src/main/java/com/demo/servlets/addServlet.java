package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		int num1=Integer.parseInt(req.getParameter("Num1"));
		int num2=Integer.parseInt(req.getParameter("Num2"));
		int add=num1+num2;
		out.println(add);
	}
	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
			doGet(request,response);
		}

}
