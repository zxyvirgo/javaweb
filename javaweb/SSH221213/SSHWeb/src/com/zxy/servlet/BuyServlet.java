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
        //1.获取要买的书   	
        String sid=request.getParameter("id"); 
        //获取需要购买的数量
        String snum = request.getParameter("quantity");
      //  System.out.print(snum);
       
        //2.得到购物车   	
        Cart cart=(Cart)request.getSession().getAttribute("cart");  	
        if(cart==null){  	
            cart=new Cart();  	
            request.getSession().setAttribute("cart", cart);  	
        }  	
        //3.把数添加到购物车中 
        //如果请求的数量为零，则不增加到购物车内
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