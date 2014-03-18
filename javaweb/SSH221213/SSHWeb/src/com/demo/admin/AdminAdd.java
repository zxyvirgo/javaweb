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

public class AdminAdd extends HttpServlet{
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)  	
      throws ServletException, IOException { 
		  
		   response.setContentType("text/html;charset=utf-8");
		   request.setCharacterEncoding("utf-8");
		  
		   String sid=request.getParameter("id"); 
           //获取需要购买的数量
		   System.out.print(sid);
		   String tempname = request.getParameter("name");
		   String name = java.net.URLDecoder.decode(tempname,"UTF-8");
		   String sprice = request.getParameter("price");
		     
		   String tempdescription = request.getParameter("description");
		   String description = java.net.URLDecoder.decode(tempdescription,"UTF-8");
		     
	       System.out.print("name"+name);
	       System.out.print("description"+description);
	       
	       int id = Integer.parseInt(sid);
	       double price =Double.parseDouble(sprice);
	           
	       Item item = new Item();
		   item.setId(id);
		   item.setName(name);
		   item.setPrice(price);
		   item.setDescription(description);
			    
		   item.printItemInfo();
	           
		   AdminService itemService = new AdminServiceImpl();
		    //   System.out.println("++=======>"+name);
		   itemService.insert(item);
		         
		   List<Item> itemlist = itemService.getAll();
		   request.setAttribute("itemlist", itemlist);
		   getServletContext().getRequestDispatcher("/WEB-INF/AdminList.jsp").forward(request, response);
	  }
	  
	  
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response)  	
      throws ServletException, IOException {  	

		   doGet(request, response);  	
}  	

}
