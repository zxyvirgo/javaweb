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
public class ServletDemo extends HttpServlet{
	private static final long serialVersionUID = 1767877373569828531L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CartService itemService = new CartServiceImpl();

		//通过请求得到想要的页面大小
     /*	String pagesizes = req.getParameter("pagesize");	
		//通过请求得到想要的页面号
		String currentpages = req.getParameter("currentpage");
		
		int pagesize = Integer.getInteger(pagesizes);
		pagesize = 10;
		int getcurrentpage = Integer.parseInt(currentpages);*/
		//起始的时候page为1
		//int getpage = Integer.parseInt(pages);
		int currentpage = 1;
		//将请求得到的当前页赋予给page
	/*	if (getcurrentpage != 1){
			currentpage= getcurrentpage;
		}*/
		
		
		int totalnum = itemService.getTotalNum() ;
		//通过请求的数据计算出到底多少页
		int pagesize = 10;
		int totalpage = totalnum/pagesize+1;
		
		int begin =(currentpage-1)*pagesize;
		int end  =begin+pagesize;
		
		
		//如果尾页记录数超过了，那么最后一页读取记录的总数就要改变
		if (end > totalnum ){
			pagesize = totalnum - begin;
		}
		
		List<Item> itemlist = itemService.getPart(begin, end);
	     itemlist.get(0).printItemInfo();
	 //    System.out.print(totalnum);
	     System.out.println(begin);
	     System.out.println(end);
		//把请求的page页发出去
	    req.getSession().setAttribute("currentpage", currentpage);
	    req.setAttribute("totalpage",totalpage);
		req.setAttribute("itemlist", itemlist);
		
		getServletContext().getRequestDispatcher("/WEB-INF/ShopList.jsp").forward(req, resp);
	//	req.getRequestDispatcher("ShopList.jsp").forward(req, resp);
	}
	

}
