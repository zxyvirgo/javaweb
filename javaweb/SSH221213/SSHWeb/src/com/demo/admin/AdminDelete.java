package com.demo.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.hibernate.Item;
import com.demo.hibernate.service.AdminService;
import com.demo.hibernate.service.AdminServiceImpl;

public class AdminDelete extends HttpServlet{
	
	  /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;



	 public void doGet(HttpServletRequest request, HttpServletResponse response)  	
	 throws ServletException, IOException {  
		      
		   	  //接受到请求的编号
		      String sid=request.getParameter("id"); 
		      int id = Integer.parseInt(sid);
		      //删除对应的数据库中的数据
			  AdminService itemService = new AdminServiceImpl();
			  itemService.delete(id);
			        
			  List<Item> itemlist = itemService.getAll();
			  request.setAttribute("itemlist", itemlist);
			  getServletContext().getRequestDispatcher("/WEB-INF/AdminList.jsp").forward(request, response); 
		  
	  }
		  
		  
		  
	  public void doPost(HttpServletRequest request, HttpServletResponse response)  	
	  throws ServletException, IOException {  	

	            doGet(request, response);  	
	            
	  }  	
	
	

}
