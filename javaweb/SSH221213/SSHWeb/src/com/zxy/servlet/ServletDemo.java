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

		//ͨ������õ���Ҫ��ҳ���С
     /*	String pagesizes = req.getParameter("pagesize");	
		//ͨ������õ���Ҫ��ҳ���
		String currentpages = req.getParameter("currentpage");
		
		int pagesize = Integer.getInteger(pagesizes);
		pagesize = 10;
		int getcurrentpage = Integer.parseInt(currentpages);*/
		//��ʼ��ʱ��pageΪ1
		//int getpage = Integer.parseInt(pages);
		int currentpage = 1;
		//������õ��ĵ�ǰҳ�����page
	/*	if (getcurrentpage != 1){
			currentpage= getcurrentpage;
		}*/
		
		
		int totalnum = itemService.getTotalNum() ;
		//ͨ����������ݼ�������׶���ҳ
		int pagesize = 10;
		int totalpage = totalnum/pagesize+1;
		
		int begin =(currentpage-1)*pagesize;
		int end  =begin+pagesize;
		
		
		//���βҳ��¼�������ˣ���ô���һҳ��ȡ��¼��������Ҫ�ı�
		if (end > totalnum ){
			pagesize = totalnum - begin;
		}
		
		List<Item> itemlist = itemService.getPart(begin, end);
	     itemlist.get(0).printItemInfo();
	 //    System.out.print(totalnum);
	     System.out.println(begin);
	     System.out.println(end);
		//�������pageҳ����ȥ
	    req.getSession().setAttribute("currentpage", currentpage);
	    req.setAttribute("totalpage",totalpage);
		req.setAttribute("itemlist", itemlist);
		
		getServletContext().getRequestDispatcher("/WEB-INF/ShopList.jsp").forward(req, resp);
	//	req.getRequestDispatcher("ShopList.jsp").forward(req, resp);
	}
	

}
