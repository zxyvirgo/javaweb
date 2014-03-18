package com.zxy.servlet;

import java.io.IOException;  	
	
import javax.servlet.ServletException;  	
import javax.servlet.http.HttpServlet;  	
import javax.servlet.http.HttpServletRequest;  	
import javax.servlet.http.HttpServletResponse;  	
import com.demo.hibernate.*;

 	
  	
@SuppressWarnings("serial")
public class ChangeQuantityServlet extends HttpServlet {  	
  	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
        String sid = request.getParameter("id");  	
        String quantity = request.getParameter("quantity");  
        
        CartService service = new CartServiceImpl();	
        Cart cart = (Cart) request.getSession().getAttribute("cart");  	
          	
         service.changeQuantity(sid,quantity,cart);  	
          	
        request.getRequestDispatcher("/WEB-INF/CartList.jsp").forward(request, response);  	
  	
    }  	
  	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
  	
        doGet(request, response);  	
    }  	
  	
}  	