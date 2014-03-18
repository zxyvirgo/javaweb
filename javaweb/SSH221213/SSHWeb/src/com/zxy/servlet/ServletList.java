
package com.zxy.servlet;

import com.demo.hibernate.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.zxy.servlet.*;

@SuppressWarnings("unused")
public class ServletList extends HttpServlet{
	private static final long serialVersionUID = 1767877373569828531L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		int pagesize = 10;
		//通过请求得到想要的页面号
	    String page = req.getParameter("page");
		int currentpage = Integer.parseInt(page);
		//起始的时候page为1
	
		//将请求得到的当前页赋予给page
		CartService itemService = new CartServiceImpl();
        System.out.print("hello");
		int totalnum = itemService.getTotalNum() ;
		//通过请求的数据计算出到底多少页
		
		int totalpage = totalnum/10+1;
		System.out.println("totalpage"+totalpage);
		
		int begin =(currentpage-1)*pagesize;
		int end  =currentpage*pagesize;
		
		
		//如果尾页记录数超过了，那么最后一页读取记录的总数就要改变
		if (end > totalnum ){
			pagesize = totalnum - begin;
		}
		System.out.print("pagesize"+pagesize);
		
		
		List<Item> itemlist = itemService.getPart(begin, pagesize);
	   
		//把请求的page页发出去

	     
	    req.getSession().setAttribute("currentpage", currentpage);
	    req.setAttribute("totalpage",totalpage);
		req.setAttribute("itemlist", itemlist);
		
		req.getRequestDispatcher("/WEB-INF/ShopList.jsp").forward(req, resp);
	//	req.getRequestDispatcher("ShopList.jsp").forward(req, resp);
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 this.doGet(req, resp); 
	
	}
	

}
