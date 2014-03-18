package com.zxy.servlet;

	
import java.io.IOException;  	
import com.demo.hibernate.*;

import javax.servlet.ServletException;  	
import javax.servlet.http.HttpServlet;  	
import javax.servlet.http.HttpServletRequest;  	
import javax.servlet.http.HttpServletResponse;  	
 
  	
@SuppressWarnings("serial")
public class ClearCartServlet extends HttpServlet {  	
   // BusinessService service=new BusinessServiceImpl();  	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  
    	 CartService service = new CartServiceImpl();
        Cart cart=(Cart) request.getSession().getAttribute("cart");  	
        service.clearCart(cart);  	       	
        request.getRequestDispatcher("/WEB-INF/CartList.jsp").forward(request, response);  	
    }  	
  	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
  	
        doGet(request, response);  	
    }  	
  	
}  