package com.demo.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public  class CartServiceImpl implements CartService {
	
	Item it = new Item();
	public Item getItem(String  sid){
	    	try{
	    		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    	    ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
	    		Item item =null;
	    		int id = Integer.parseInt(sid);
	    	    item = itemDao.findById(id);
	    	    return item;
	     }catch(Exception e){
	    	 e.printStackTrace();
	   	 return it;
	     }
	     
	  }  
	  
	
	@SuppressWarnings("unchecked")
	public List<Item> getAll(){
		  
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		  List<Item> list = itemDao.findAll();
		  return list;
	  }
	  
	  
	@SuppressWarnings("unchecked")
	public List<Item> getPart(int i, int j){
		
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		  List<Item> list = itemDao.findPart(i, j);
		  return list;
		  
	  }
	  
	
	public int getTotalNum(){
	    	
	      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		  int count  = itemDao.getTotalNum();
		  return count;
	  }
		
	public void deleteCartItem(String sid, Cart cart){
		
		  int num = Integer.parseInt(sid);
		  cart.deleteCartItem(num);
		  
	  }
	  
	  
	public void clearCart(Cart cart){
		
		  cart.clearCartItem();
	  }
	  
	  
	public void changeQuantity(String sid, String quantity, Cart cart){
		
		  int num = Integer.parseInt(sid);
		  int q = Integer.parseInt(quantity);
		  cart.changeQuantity(num, q);
		  
	  }
	  
	
	public static void main(String[] args){
			
		  CartService itemService = new CartServiceImpl();
		  @SuppressWarnings("unused")
		  List<Item> itemlist = itemService.getPart(20, 2);
		  
	  }
	  
	     
}
