package com.zxy.servlet;

import java.io.IOException;
import com.demo.hibernate.*;

import javax.servlet.ServletException;  	
import javax.servlet.http.HttpServlet;  	
import javax.servlet.http.HttpServletRequest;  	
import javax.servlet.http.HttpServletResponse;  	
  	
 	
  	
@SuppressWarnings("serial")
public class BuyServlet extends HttpServlet {  	
    //BusinessServiceImpl service=new BusinessServiceImpl();  	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
        //1.��ȡҪ�����   	
        String sid=request.getParameter("id"); 
        //��ȡ��Ҫ���������
        String snum = request.getParameter("quantity");
      //  System.out.print(snum);
       
        //2.�õ����ﳵ   	
        Cart cart=(Cart)request.getSession().getAttribute("cart");  	
        if(cart==null){  	
            cart=new Cart();  	
            request.getSession().setAttribute("cart", cart);  	
        }  	
        //3.�������ӵ����ﳵ�� 
        //������������Ϊ�㣬�����ӵ����ﳵ��
        int num = 0;
        num = Integer.parseInt(snum);
        if (num!=0){
        CartService service = new CartServiceImpl();
        Item Item =service.getItem(sid);  	
        CartItem cartItem = new CartItem(Item,num);
        cart.addCartItem(cartItem);
        }
        request.getRequestDispatcher("/WEB-INF/CartList.jsp").forward(request, response);   	
          	
  	
    }  	
  	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  	
            throws ServletException, IOException {  	
  	
        doGet(request, response);  	
    }  	
  	
}  	