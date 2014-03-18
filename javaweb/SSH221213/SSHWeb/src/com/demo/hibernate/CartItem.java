package com.demo.hibernate;
//购物车物品类
public class CartItem
{
	private Item item;
	private int quantity = 0;
	private double price = 0;
	
	//constructor 
	public CartItem(Item item, int quantity)
	{
		this.item = item;
		this.quantity = quantity;
		this.price = item.getPrice()*quantity;	
	}
	
	//get()和set()是为了单独取成员的值
	
	public void setitem(Item item)
	{
		this.item = item;
		
	}
	
	
	//改变数量会自动改变价格
	public void setquantity(int quantity)
	{   
		this.quantity = quantity;
		price = item.getPrice()*quantity;	
	}
	
	
	public Item getitem()
	{
		return item;
	}
	
	public int getquantity()
	{
		return quantity;
	}
	
	public double getprice()
	{
		return price;
	}
	
	//输出购物车物品类信息
	
	
	public void printCartItemInfo()
	{
		
		   item.printItemInfo();
		   print("购买数量:"+ quantity+" ");
		   print("购物车物品类总价:" + price+" ");
		   System.out.println();
     }  

	private void print(Object o) 
	{
			// TODO Auto-generated method stub
			System.out.print(o);
			
	}
}
