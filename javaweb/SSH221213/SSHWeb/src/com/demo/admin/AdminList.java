package com.demo.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.hibernate.service.AdminService;
import com.demo.hibernate.service.AdminServiceImpl;
import com.demo.hibernate.Item;

public class AdminList extends HttpServlet{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)  	
    throws ServletException, IOException {
		
		       AdminService itemService = new AdminServiceImpl();
		    
			 	int currentpage = 1;
	
				int totalnum = itemService.getTotalNum() ;
				//通过请求的数据计算出到底多少页
				int pagesize = 10;
				int totalpage = totalnum/pagesize+1;
					
				int begin =(currentpage-1)*pagesize;
				int end  =begin+pagesize;
					
					
				//如果尾页记录数超过了，那么最后一页读取记录的总数就要改变
				if (end > totalnum ){
					pagesize = totalnum - begin;
				}//end if
					
				List<Item> itemlist = itemService.getPart(begin, end);
				  
				//把请求的page页发出去
				request.getSession().setAttribute("currentpage", currentpage);
				request.setAttribute("totalpage",totalpage);
				request.setAttribute("itemlist", itemlist);
				getServletContext().getRequestDispatcher("/WEB-INF/AdminList.jsp").forward(request, response); 
	  }
	  
	  
	  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  	
    throws ServletException, IOException {  	

            doGet(request, response);  	
     }  	

}
