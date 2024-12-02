package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidtateServlet
 */
@WebServlet("/validate")
public class ValidtateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");   
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		LoginService ls= new LoginServicesImpl();
		MyUser user= ls.validateUser(uname,pass);
		if(user!=null && user.getRole().equals("admin")) {
//			out.println("login SucceSSfull");
			RequestDispatcher rd=req.getRequestDispatcher("showprod");
			rd.forward(req, res);
		}else {
			out.println("Invalid Login");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req, res);
		}
		
		   
	}

}
