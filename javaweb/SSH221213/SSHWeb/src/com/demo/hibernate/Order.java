package com.demo.hibernate;
class Customer
{
	
}
class Member
{
	
}


public class Order 
{
  private Cart cart = new Cart();
  private int flag = -1;
  private double account;
  Order(Cart cart,Customer customer)
  {   
	  flag = 0;
//	  System.out.print("flag" + flag);
	  this.cart = cart;
	  
  }
  
  Order(Cart cart,Member member)
  {   
	  flag = 1;
//	  System.out.print("flag" + flag);
	  this.cart = cart;
	  
  }
  
  public void setCart(Cart cart)
  {
	  this.cart = cart;
	  
  }
  
  public Cart getCart()
  {
	  return cart;
  }
  
  public void setAccount(double account )
  {
	  this.account = account;
	  
  }
  public double getAccount()
  {
	  return account;
  }
  
  public void SettleAccount()
  {
	  if (flag == 0)
	  {
		  account = cart.getPrice()+(double)8;
	  }
	  else
	  {
		  account = cart.getPrice()*0.7;
	  }
	  
  }
  
  public void printOrderInfo()
  {   
	  cart.printCartInfo();
	  this.SettleAccount();
	  if (flag == 0)
	  {   
		
		  System.out.print("普通用户的结算金额： "+account);
	  }
	  else 
	  {
		 
		  System.out.print("会员的结算金额： "+account);
	  }
  }
}
