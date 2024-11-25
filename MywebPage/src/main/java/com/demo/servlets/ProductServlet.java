package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/Html");
		PrintWriter out=res.getWriter();
		ProductService ps= new ProductServiceImpl(null);
		List<Product> plist=ps.getAllData();
		if(plist!=null) {
			out.print("<table><tr><th>Product Id</th><th>Name</th><th>Qty</th><th>Expiry Date</th><th>Cid</th><th>Action</th>");
		for(Product p:plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"/td><td>"+p.getPrice()+"</td>");
			String dt=p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			out.println("<td>"+dt+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='#'>edit</a>/<a href='#'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.println("<form action='addproduct.html'>");
		  out.println("<button type='submit' name='btn' id='btn' value='add'>Add new Product</button>");
		out.println("</form>");
	}
}
		
		
	}


