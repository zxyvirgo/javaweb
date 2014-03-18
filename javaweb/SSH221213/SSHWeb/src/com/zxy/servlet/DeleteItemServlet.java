package com.zxy.servlet;

import java.io.IOException;  	
import com.demo.hibernate.*;

import javax.servlet.ServletException;  	
import javax.servlet.http.HttpServlet;  	
import javax.servlet.http.HttpServletRequest;  	
import javax.servlet.http.HttpServletResponse;  	
  	
  	
@SuppressWarnings("serial")
public class DeleteItemServlet extends HttpServlet {  	
    //����������ߵķ����ӹ�������ɾ����Ҫɾ������   	
  //  BusinessService service=new BusinessServiceImpl();  	
  	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
        //��ȡ��������   
      	
        CartService service = new CartServiceImpl();
        String sid=request.getParameter("id");  	
        Cart cart=(Cart)request.getSession().getAttribute("cart");  	
        	
        service.deleteCartItem(sid,cart);
        cart.printCartInfo();
        request.getRequestDispatcher("/WEB-INF/CartList.jsp").forward(request, response);  	
  	
    }  	
  	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
  	
        doGet(request, response);  	
    }  	
  	
}  	
