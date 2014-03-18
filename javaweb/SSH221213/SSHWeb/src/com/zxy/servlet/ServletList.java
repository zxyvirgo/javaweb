
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
		//ͨ������õ���Ҫ��ҳ���
	    String page = req.getParameter("page");
		int currentpage = Integer.parseInt(page);
		//��ʼ��ʱ��pageΪ1
	
		//������õ��ĵ�ǰҳ�����page
		CartService itemService = new CartServiceImpl();
        System.out.print("hello");
		int totalnum = itemService.getTotalNum() ;
		//ͨ����������ݼ�������׶���ҳ
		
		int totalpage = totalnum/10+1;
		System.out.println("totalpage"+totalpage);
		
		int begin =(currentpage-1)*pagesize;
		int end  =currentpage*pagesize;
		
		
		//���βҳ��¼�������ˣ���ô���һҳ��ȡ��¼��������Ҫ�ı�
		if (end > totalnum ){
			pagesize = totalnum - begin;
		}
		System.out.print("pagesize"+pagesize);
		
		
		List<Item> itemlist = itemService.getPart(begin, pagesize);
	   
		//�������pageҳ����ȥ

	     
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
