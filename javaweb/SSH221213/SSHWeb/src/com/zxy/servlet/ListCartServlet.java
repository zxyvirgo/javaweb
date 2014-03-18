package com.zxy.servlet;

//ListCartServlet.java   										
  					
import java.io.IOException;  					
  					
import javax.servlet.ServletException;  					
import javax.servlet.http.HttpServlet;  					
import javax.servlet.http.HttpServletRequest;  					
import javax.servlet.http.HttpServletResponse;  					

import com.demo.hibernate.Cart;
  					
@SuppressWarnings("serial")
public class ListCartServlet extends HttpServlet {  					
  					
    public void doGet(HttpServletRequest request, HttpServletResponse response)  					
            throws ServletException, IOException { 
    	
    	Cart cart=(Cart)request.getSession().getAttribute("cart");  	
        if(cart==null){  	
            cart=new Cart();  	
            request.getSession().setAttribute("cart", cart);  	
        }  
        request.getRequestDispatcher("/WEB-INF/CartList.jsp").forward(request, response);  					
    }  					
  					
    public void doPost(HttpServletRequest request, HttpServletResponse response)  					
            throws ServletException, IOException {  					
  					
        doGet(request, response);  					
    }  					
  					
}  					

