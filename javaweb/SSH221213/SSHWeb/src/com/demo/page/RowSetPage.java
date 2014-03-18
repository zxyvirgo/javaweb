package com.demo.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RowSetPage extends HttpServlet{
	private static final long serialVersionUID = 1767877373569828531L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   @SuppressWarnings("unused")
		String sid=req.getParameter("page"); 
		
		getServletContext().getRequestDispatcher("/WEB-INF/ShopList.jsp").forward(req, resp);
	//	req.getRequestDispatcher("ShopList.jsp").forward(req, resp);
	}

}
