package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/showprod")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getAllData();
		request.setAttribute("plist", plist);
		RequestDispatcher rd=request.getRequestDispatcher("displayproducts.jsp");
		rd.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
